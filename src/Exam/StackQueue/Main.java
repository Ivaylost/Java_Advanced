package Exam.StackQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<Integer> queue = new ArrayDeque<>(); //queue - add poll peek Shft+F6 rename
        ArrayDeque<Integer> stack = new ArrayDeque<>(); //stack - push pop peek

        Arrays.stream(sc.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(queue::add);

        Arrays.stream(sc.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(stack::push);

        while (!queue.isEmpty() && !stack.isEmpty()) {
            int q = queue.peek();
            int s = stack.peek();
            int sum = q+s;

            switch (sum) {
                case 150:
                    break;
                case 250:
                    break;
                case 300:
                    break;
                case 400:
                    break;
            }
        }



        System.out.println();
    }
}
