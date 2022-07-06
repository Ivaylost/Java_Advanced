package Advance.FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] range = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String condition = sc.nextLine();

        System.out.println(IntStream.rangeClosed(range[0], range[1])
                .boxed()
                .filter(predicate(condition))
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }

    public static Predicate<Integer> predicate(String condition){
        if(condition.equals("odd")){
            return p -> p%2 != 0;
        }
        return p -> p%2 == 0;
    }
}
