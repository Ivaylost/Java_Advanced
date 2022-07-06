package Advance.Generics.Swap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Box> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            Box<String> box = new Box<>(input);
            list.add(box);
        }

        swap(sc, list);

        list.forEach(System.out::println);
    }

    private static void swap(Scanner sc, List<Box> list) {
        int[] indexes = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Box first = list.get(indexes[0]);
        Box second = list.get(indexes[1]);

        list.set(indexes[1], first);
        list.set(indexes[0], second);
    }
}
