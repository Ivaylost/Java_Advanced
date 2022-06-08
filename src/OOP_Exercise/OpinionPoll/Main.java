package OOP_Exercise.OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        List<Person> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] splitter = sc.nextLine().split("\\s+");
            String name = splitter[0];
            int age = Integer.parseInt(splitter[1]);
            Person p = new Person(name, age);
            list.add(p);
        }

        list.stream()
                .filter(x -> x.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);
    }
}
