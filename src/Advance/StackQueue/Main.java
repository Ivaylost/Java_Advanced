package Advance.StackQueue;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<Double> milkQ = new ArrayDeque<>(); //queue - add poll peek Shft+F6 rename
        ArrayDeque<Double> cacaoS = new ArrayDeque<>(); //stack - push pop peek

        Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .forEach(milkQ::add);

        Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .forEach(cacaoS::push);

        String chocolates = null;
        Map<String, Integer> result = new TreeMap<>();

        while (!milkQ.isEmpty() && !cacaoS.isEmpty()) {
            double m = milkQ.peek();
            double c = cacaoS.peek();

            if(m == 0 && c==0){
                milkQ.poll();
                cacaoS.pop();
            } else {
                double cacaoPercent = (c / (c + m))*100;

                if (cacaoPercent == 30) {
                    chocolates = "Milk Chocolate";
                }

                if (cacaoPercent == 50) {
                    chocolates = "Dark Chocolate";
                }

                if (cacaoPercent == 100) {
                    chocolates = "Baking Chocolate";
                }

            }
            if(chocolates != null){
                result.putIfAbsent(chocolates, 0);
                int value = result.get(chocolates);
                result.put(chocolates, value+1);
                milkQ.poll();
                cacaoS.pop();
            } else {
                double x = milkQ.poll();
                milkQ.add(x + 10);
                cacaoS.pop();
            }

            chocolates = null;
        }

        if(result.size() == 3){
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        for(Map.Entry<String,Integer> entry : result.entrySet()) {
            System.out.printf(" # %s --> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
