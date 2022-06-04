package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Consumer<String> print = p -> System.out.printf("Sir %s%n", p);
        Arrays.stream(sc.nextLine().split("\\s+"))
                .forEach(print);
    }
}
