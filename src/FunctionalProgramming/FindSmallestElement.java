package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindSmallestElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> integers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> getIndex = x -> {
            int minElement = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0;i < integers.size();i++ ){
                if(integers.get(i) <= minElement){
                    minElement = integers.get(i);
                    index = i;
                }
            }
            return index;
        };

        System.out.println(getIndex.apply(integers));
    }
}
