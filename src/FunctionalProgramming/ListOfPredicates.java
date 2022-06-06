package FunctionalProgramming;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Integer> list = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Predicate<Integer> predicate = x -> {
            for( var i : list){
                if(x%i != 0){
                    return false;
                }
            }
            return true;
        };

        IntStream.rangeClosed(1, n)
                .filter(predicate::test)
                .forEach(x -> System.out.print(x + " "));

    }
}
