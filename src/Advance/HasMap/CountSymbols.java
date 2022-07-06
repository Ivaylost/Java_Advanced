package Advance.HasMap;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        Map<Character, Integer> map = new TreeMap<>();

        for(Character c:input.toCharArray()){
            map.putIfAbsent(c,0);
            int count = map.get(c);
            count++;
            map.put(c,count);
        }

        map.forEach((key, value)->{
            System.out.printf("%c: %d time/s", key, value);
            System.out.println();
        });
    }
}
