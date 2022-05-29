package HasMap;

import java.util.*;
import java.util.stream.Collectors;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, HashSet<String>> map = new LinkedHashMap<>();

        String input = sc.nextLine();
        while (!input.equals("JOKER")){
            String[] result = input.split(": ");
            map.putIfAbsent(result[0], new HashSet<String>());
            HashSet<String> cards = map.get(result[0]);
            cards.addAll(Arrays.stream(result[1].split(", ")).collect(Collectors.toList()));
            map.put(result[0], cards);

            input= sc.nextLine();
        }

        Map<String, Integer> resultMap = new LinkedHashMap<>();

        map.forEach((key, value)->{
            String name = key;
            int points = getPoints(value);
            resultMap.put(name, points);
        });

        resultMap.forEach((key, value)->{
            System.out.printf("%s: %d%n", key, value);
        });
    }

    public static int getPoints(HashSet<String> cards){
        int sum = 0;
        for(var item: cards){
            sum += getValue(item);
        }
        return sum;
    }

    public static int getValue(String cards){
        Map<Character, Integer> multipliers = new HashMap<>();
        multipliers.put('S', 4);
        multipliers.put('H', 3);
        multipliers.put('D', 2);
        multipliers.put('C', 1);

        Map<Character, Integer> power = new HashMap<>();
        power.put('2', 2);
        power.put('3', 3);
        power.put('4', 4);
        power.put('5', 5);
        power.put('6', 6);
        power.put('7', 7);
        power.put('8', 8);
        power.put('9', 9);
        power.put('J', 11);
        power.put('Q', 12);
        power.put('K', 13);
        power.put('A', 14);

        if(cards.startsWith("10")){
            char x = cards.charAt(2);
            return 10*multipliers.get(x);
        } else {
            return power.get(cards.charAt(0))*multipliers.get(cards.charAt(1));
        }
    }
}
