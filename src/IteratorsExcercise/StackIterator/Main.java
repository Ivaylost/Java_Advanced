package IteratorsExcercise.StackIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        ListyIterator iterator1 = null;


        while (!command.equals("END")) {

            String[] splitter = command.split("\\s+");

            switch (splitter[0]) {
                case "Create":
                    if(splitter.length > 0) {
                        iterator1 = new ListyIterator(Arrays.copyOfRange(splitter, 1, splitter.length));
                    } else {
                        iterator1 = new ListyIterator();
                    }
                    break;
                case "Move":
                    System.out.println(iterator1.move());
                    break;
                case "Print":
                    try {
                        iterator1.print();
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "HasNext":
                    System.out.println(iterator1.hasNext());
                    break;
                case "PrintAll":
                    for (String s : iterator1) {
                        System.out.print(s + " ");
                    }
                    System.out.println();
                    break;
            }

            command = sc.nextLine();
        }
    }
}
