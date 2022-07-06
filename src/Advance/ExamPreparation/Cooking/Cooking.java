package Advance.ExamPreparation.Cooking;

import java.util.*;
import java.util.stream.Collectors;

public class Cooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // liquid Queue, ingredients Stack

        Map<String, Integer> result = new TreeMap<>();
        result.put("Bread", 0);
        result.put("Cake", 0);
        result.put("Fruit Pie", 0);
        result.put("Pastry", 0);

        ArrayDeque<Integer> liquidQueue = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();

        Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(ingredientsStack::push);

        while (!liquidQueue.isEmpty() && !ingredientsStack.isEmpty()){
            int liquid = liquidQueue.poll();
            int ingredients = ingredientsStack.poll();
            int sum = liquid+ingredients;
            String product;

            switch (sum){
                case 25:
                    product = "Bread";
                    break;
                case 50:
                    product = "Cake";
                    break;
                case 75:
                    product = "Pastry";
                    break;
                case 100:
                    product = "Fruit Pie";
                    break;
                default:
                    product = null;
                    break;
            }

            if (product == null){
                ingredientsStack.push(ingredients+3);
            } else {
                int x = result.get(product);
                result.put(product, x + 1);
            }
        }

        boolean check = true;
        for(Map.Entry<String,Integer> entry : result.entrySet()) {
            int value = entry.getValue();
            if(value == 0){
                check = false;
                break;
            }
        }

        if(check){
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        System.out.printf("Liquids left: %s%n", liquidQueue.isEmpty() ? "none" : liquidQueue.stream().map(String::valueOf)
                .collect(Collectors.joining(", ")));

        System.out.printf("Ingredients left: %s%n", ingredientsStack.isEmpty() ? "none" : ingredientsStack.stream().map(String::valueOf)
                        .collect(Collectors.joining(", ")));

        for(Map.Entry<String,Integer> entry : result.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
    }
}
