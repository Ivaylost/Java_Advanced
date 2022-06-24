package ExamOct2021;

import java.util.*;
import java.util.stream.Collectors;

public class Cocktails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<Integer> ingredientsQ = new ArrayDeque<>(); //queue - add poll peek
        ArrayDeque<Integer> freshnessS = new ArrayDeque<>(); // push pop peek

        Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(ingredientsQ::add);

        Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(freshnessS::push);

        int cocktails = 0;

        Map<String, Integer> all = new TreeMap<>();

        while (!ingredientsQ.isEmpty() && !freshnessS.isEmpty()) {
            int ingredient = ingredientsQ.peek();
            int fresh = freshnessS.peek();
            int sum = ingredient * fresh;
            int value = 0;
            String cocktail = null;
            boolean x = true;
            if (fresh == 0) {
                freshnessS.pop();
                x = false;
            }

            if (ingredient == 0) {
                ingredientsQ.poll();
                x = false;
            }
            if(x) {
                switch (sum) {
                    case 150:
                        cocktail = "Pear Sour";
                        break;
                    case 250:
                        cocktail = "The Harvest";
                        break;
                    case 300:
                        cocktail = "Apple Hinny";
                        break;
                    case 400:
                        cocktail = "High Fashion";
                        break;
                }
                if (cocktail != null) {
                    all.putIfAbsent(cocktail, 0);
                    freshnessS.pop();
                    ingredientsQ.poll();
                    value = all.get(cocktail);
                    all.put(cocktail, value + 1);
                } else {
                    freshnessS.pop();
                    int element = ingredientsQ.poll();
                    ingredientsQ.add(element + 5);
                }
            }
        }

        if (all.size() == 4) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        //int sum = all.entrySet().stream().mapToInt(x -> x.getValue()).sum();
        int sumF = freshnessS.stream().mapToInt(x -> x).sum();
        int sumI = ingredientsQ.stream().mapToInt(x -> x).sum();

        if (sumI > 0) {
            System.out.printf("Ingredients left: %d%n", sumI);
        }

        for (var item : all.entrySet()) {
            System.out.printf(" # %s --> %d%n", item.getKey(), item.getValue());
        }
    }
}
