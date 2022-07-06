package Advance.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");

        ArrayDeque<String> stack = new ArrayDeque<>();
        for(String item: input){
            stack.push(item);
        }

       for(String item:stack){
           System.out.print(item + " ");
       }
    }
}
