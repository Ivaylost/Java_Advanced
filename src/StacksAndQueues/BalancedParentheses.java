package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String brackets = sc.nextLine();
        ArrayDeque<Character> opening = new ArrayDeque<>();
        boolean isBalanced = true;

        for (int i = 0; i < brackets.length(); i++) {
            char current = brackets.charAt(i);
            if (current == '{' || current == '(' || current == '[') {
                opening.push(current);
            } else {
                if(opening.isEmpty()){
                    isBalanced = false;
                    break;
                }
                char x = opening.pop();
                if (current == '}' && x !='{'){
                    isBalanced = false;
                    break;
                } else if(current == ')' && x !='('){
                    isBalanced = false;
                    break;
                } else if(current == ']' && x !='['){
                    isBalanced = false;
                    break;
                }
            }
        }
        if(isBalanced){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
