package Exam.StackQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<Integer> queue = new ArrayDeque<>(); //queue - add poll peek
        ArrayDeque<Integer> stack = new ArrayDeque<>(); // push pop peek

        Arrays.stream(sc.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(queue::add);

        Arrays.stream(sc.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(stack::push);

        int qq = queue.peek();
        int ss = stack.peek();

        int q = queue.poll();
        int s = stack.pop();



        System.out.println();
    }
}
