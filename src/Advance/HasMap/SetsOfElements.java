package Advance.HasMap;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] input = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Set<String> first = new LinkedHashSet<>();
        Set<String> second = new LinkedHashSet<>();

        for (int i = 0; i < input[0]; i++) {
            first.add(sc.nextLine());
        }

        for (int i = 0; i < input[1]; i++) {
            second.add(sc.nextLine());
        }

        for(String s:first){
            if(second.contains(s)){
                System.out.print(s+" ");
            }
        }
    }
}
