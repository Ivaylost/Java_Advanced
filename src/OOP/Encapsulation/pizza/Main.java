package OOP.Encapsulation.pizza;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] pizza = sc.nextLine().split(" ");
        String[] dough = sc.nextLine().split(" ");
        try{
            Pizza p= new Pizza(pizza[1], Integer.parseInt(pizza[2]));
            Dough d = new Dough(dough[1], dough[2], Double.parseDouble(dough[3]));
            p.setDough(d);
            String command = sc.nextLine();
            while (!"END".equals(command)){
                String[] c = command.split(" ");
                Topping topping = new Topping(c[1], Double.parseDouble(c[2]));

                p.addTopping(topping);
                command = sc.nextLine();
            }
            System.out.printf("%s - %.2f", p.getName(), p.getOverallCalories());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
