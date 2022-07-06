package Advance.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque();
        int num = Integer.parseInt(sc.nextLine());

        for(int i=0; i<num; i++){
            String command = sc.nextLine();
            if(command.equals("2")){
                stack.pop();
            } else if(command.equals("3")){
                System.out.println(Collections.max(stack));
            } else {
                String[] commands = command.split("\\s+");
                stack.push(Integer.parseInt(commands[1]));
            }
        }
    }
}