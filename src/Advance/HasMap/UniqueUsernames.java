package Advance.HasMap;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i = Integer.parseInt(sc.nextLine());
        Set<String> input = new LinkedHashSet<>();

        for (int j = 0; j < i; j++) {
            input.add(sc.nextLine());
        }

        input.forEach(System.out::println);
    }
}
