package Advance.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] operations = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] nums = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < operations[0]; i++) {
            queue.offer(nums[i]);
        }

        for (int i = 0; i < operations[1]; i++) {
            queue.poll();
        }

        if(queue.contains(operations[2])){
            System.out.println("true");
        } else if(queue.isEmpty()){
            System.out.println(0);
        } else {
            System.out.println(Collections.min(queue));
        }
    }
}
