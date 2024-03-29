package Advance.FunctionalProgramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer[] ints = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Comparator<Integer> comparator = (n1, n2) -> {
            if(n1 % 2 == 0 && n2 % 2 != 0){
                return -1;
            } else if(n1 %2 != 0 && n2 % 2 == 0){
                return 1;
            } else {
                return n1.compareTo(n2);
            }
        };

        Arrays.sort(ints, comparator);
        Arrays.stream(ints).forEach(x -> System.out.print(x + " "));
    }
}
