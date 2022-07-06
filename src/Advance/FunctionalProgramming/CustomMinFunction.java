package Advance.FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Function<int[], Integer> findMin = x -> Arrays.stream(x)
                .summaryStatistics().getMin();

        int[] intStream = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(findMin.apply(intStream));
    }
}
