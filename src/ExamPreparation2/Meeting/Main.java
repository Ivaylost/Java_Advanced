package ExamPreparation2.Meeting;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int matches = 0;

        ArrayDeque<Integer> femalesQ = new ArrayDeque<>(); //queue - add poll peek
        ArrayDeque<Integer> malesS = new ArrayDeque<>(); // push pop peek

        Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(malesS::push);

        Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(femalesQ::add);


        while (!femalesQ.isEmpty() && !malesS.isEmpty()) {
            int female = femalesQ.peek();
            int male = malesS.peek();

            if(female <= 0) {
                femalesQ.poll();
            } else if(male <= 0) {
                malesS.pop();
            } else if(female % 25 == 0) {
                female = femalesQ.poll();
                male = malesS.pop();
                if(!femalesQ.isEmpty()){
                    female = femalesQ.poll();
                }
            } else if(male % 25 == 0) {
                male = malesS.pop();
                female = femalesQ.poll();
                if(!malesS.isEmpty()){
                    male = malesS.pop();
                }
            } else {
                if(female == male) {
                    male = malesS.pop();
                    female = femalesQ.poll();
                    matches++;
                } else {
                    male = malesS.pop();
                    female = femalesQ.poll();
                    malesS.push(male-2);
                }
            }
        }
        System.out.println();
    }
}
