package IteratorsExcercise.ListyIterator;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        ListyIterator iterator = null;


        while (!command.equals("END")) {

            String[] splitter = command.split("\\s+");

            switch (splitter[0]) {
                case "Create":
                    if(splitter.length > 0) {
                        iterator = new ListyIterator(Arrays.copyOfRange(splitter, 1, splitter.length));
                    } else {
                        iterator = new ListyIterator();
                    }
                    break;
                case "Move":
                    System.out.println(iterator.move());
                    break;
                case "Print":
                    try {
                        iterator.print();
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "HasNext":
                    System.out.println(iterator.hasNext());
                    break;
            }

            command = sc.nextLine();
        }
    }
}
