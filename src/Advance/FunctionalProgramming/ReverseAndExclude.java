package Advance.FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] ints = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int num = Integer.parseInt(sc.nextLine());

        IntConsumer print = p -> System.out.printf("%d ", p);

        IntStream.range(0, ints.length)
                .map(i -> ints[ints.length - 1 - i])
                .filter(x -> x % num != 0)
                .forEach(print);
    }
}
