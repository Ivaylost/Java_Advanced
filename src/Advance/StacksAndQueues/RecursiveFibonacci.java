package Advance.StacksAndQueues;

import java.util.Scanner;

public class RecursiveFibonacci {

    public static long[] memory;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = Integer.parseInt(sc.nextLine());
        memory = new long[input+1];
        long result = fib(input);
        System.out.println(result);
    }

    public static long fib(int input){
        if(input < 2){
            return 1;
        }
        if(memory[input] != 0){
            return memory[input];
        }
        memory[input] =  fib(input-1) + fib(input-2);
        return memory[input];
    }
}
