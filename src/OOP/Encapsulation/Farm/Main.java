package OOP.Encapsulation.Farm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        int age = Integer.parseInt(sc.nextLine());

        try {
            Chicken chicken = new Chicken(name, age);
            System.out.printf("Chicken %s (age %d) can produce %.2f eggs per day.",
                    chicken.getName(), chicken.getAge(), chicken.productPerDay());
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
