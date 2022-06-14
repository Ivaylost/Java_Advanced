package Generics.CustomListSorter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomList<String> list = new CustomList<>();

        String input = sc.nextLine();
        while (!input.equals("END")){
            String[] tokens = input.split("\\s+");

            switch (tokens[0]){
                case "Add":
                    list.add(tokens[1]);
                    break;
                case "Remove":
                    list.remove(Integer.parseInt(tokens[1]));
                    break;
                case "Contains":
                    System.out.println(list.contains(tokens[1]));
                    break;
                case "Swap":
                    list.swap(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                    break;
                case "Greater":
                    System.out.println(list.countGreaterThen(tokens[1]));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
                    list.getList().forEach(System.out::println);
                    break;
                case "Sort":
                    Sorter.sort(list);
                    break;
                default:
                    throw new IllegalArgumentException("Wrong input");
            }


            input = sc.nextLine();
        }
    }
}
