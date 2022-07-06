package Advance.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> ints = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        UnaryOperator<List<Integer>> addFunction = p -> p.stream().map(i -> i + 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> subtractFunction = p -> p.stream().map(i -> i - 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> multiplyFunction = p -> p.stream().map(i -> i*2).collect(Collectors.toList());
        Consumer<Integer> print = x -> System.out.printf("%d ", x);

        String command = sc.nextLine();

        while (!"end".equals(command)){
            switch (command){
                case "print":
                    ints.forEach(print);
                    System.out.println();
                    break;
                case "multiply":
                    ints = multiplyFunction.apply(ints);
                    break;
                case "subtract":
                    ints = subtractFunction.apply(ints);
                    break;
                case "add":
                    ints = addFunction.apply(ints);
                    break;
            }
            command = sc.nextLine();
        }
    }
}
