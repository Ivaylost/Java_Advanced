package Advance.ExamPreparation1.FlowerWreaths;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<Integer> rosesQ = new ArrayDeque<>();
        ArrayDeque<Integer> liliesS = new ArrayDeque<>();

        Arrays.stream(sc.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(liliesS::push);

        Arrays.stream(sc.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(rosesQ::add);

        int wreathCount = 0;
        int rest = 0;

        while (!rosesQ.isEmpty() && !liliesS.isEmpty()) {
            int rose = rosesQ.poll();
            int lilie = liliesS.pop();
            int sum = rose + lilie;

            while (true) {
                if(sum >15) {
                    lilie -=2;
                    sum = lilie + rose;
                } else if(sum == 15) {
                    wreathCount++;
                    break;
                } else if(sum < 15){
                    rest += sum;
                    break;
                }
            }
        }
        int x = rest/15;
        wreathCount += x;
        if(wreathCount < 5){
            System.out.printf("You didn't make it, you need %d wreaths more!%n", 5 - wreathCount);
        } else {
            System.out.printf("You made it, you are going to the competition with %d wreaths!%n", wreathCount);
        }
    }
}
