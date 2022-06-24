package ExamOct2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Bouquets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<Integer> daffodilsQ = new ArrayDeque<>(); //queue - add poll peek Shft+F6 rename
        ArrayDeque<Integer> tulipsS = new ArrayDeque<>(); //stack - push pop peek

        Arrays.stream(sc.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(daffodilsQ::add);

        Arrays.stream(sc.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(tulipsS::push);

        int flowers = 0;
        int bouquets = 0;

        while (!daffodilsQ.isEmpty()&&!tulipsS.isEmpty()){
            int daffodils = daffodilsQ.peek();
            int tulip = tulipsS.peek();
            int sum = daffodils+tulip;

            if(sum == 15){
                bouquets++;
                daffodilsQ.poll();
                tulipsS.pop();
            } else if(sum<15){
                daffodilsQ.poll();
                tulipsS.pop();
                flowers += sum;
            } else {
                tulipsS.push(tulipsS.pop()-2);
            }
        }

        bouquets += flowers/15;

        if(bouquets >= 5){
            System.out.println(String.format("You made it! You go to the competition with %d bouquets!", bouquets));
        } else {
            System.out.println(String.format("You failed... You need more %d bouquets.", 5 - bouquets));
        }
    }
}
