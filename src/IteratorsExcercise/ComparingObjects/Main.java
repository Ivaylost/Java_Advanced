package IteratorsExcercise.ComparingObjects;

import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        List<Person> persons = new ArrayList<>();

        while (!input.equals("END")){
            String[] tokens = input.split(" ");
            persons.add(new Person(tokens[0], Integer.parseInt(tokens[1]), tokens[2]));

            input = sc.nextLine();
        }
        int index = Integer.parseInt(sc.nextLine());
        Person person = persons.get(index-1);
        long count = persons.stream().filter(x -> x.compareTo(person) == 0).count();
        String result = count == 1 ? "No matches" : String.format("%d %d %d", count, persons.size()-count, persons.size());
        System.out.println(result);
    }
}
