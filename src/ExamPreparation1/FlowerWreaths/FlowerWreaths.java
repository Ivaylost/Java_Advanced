package ExamPreparation1.FlowerWreaths;

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

        while (!rosesQ.isEmpty() && !liliesS.isEmpty()) {
            int rose = rosesQ.poll();
            int lilie = liliesS.pop();
            int sum = rose + lilie;

            if(sum == 15) {
                wreathCount++;
            } else if(sum >15){

            } else if(sum < 15){

            }

            System.out.println();
        }
    }
}
