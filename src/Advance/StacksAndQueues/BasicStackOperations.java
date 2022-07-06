package Advance.StacksAndQueues;

import java.util.*;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] nums = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < input[0]; i++) {
            stack.push(nums[i]);
        }

        for(int i = 0; i < input[1]; i++){
            stack.pop();
        }

        if(stack.contains(input[2])){
            System.out.println("true");
        } else if(stack.isEmpty()){
            System.out.println(0);
        } else {
            System.out.println(Collections.min(stack));
        }
    }
}
