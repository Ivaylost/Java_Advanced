package Advance.FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Predicate<String> predicate = i -> i.length() <= n;

        Arrays.stream(sc.nextLine().split("\\s+"))
                .filter(predicate)
                .forEach(System.out::println);
    }
}
