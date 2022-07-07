package OOP.Encapsulation.Box;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double l = Double.parseDouble(sc.nextLine());
        double w = Double.parseDouble(sc.nextLine());
        double h = Double.parseDouble(sc.nextLine());

        try {
            Box box = new Box(l, w, h);
            System.out.printf("Surface Area - %.2f%n", box.calculateSurfaceArea());
            System.out.printf("Lateral Surface Area - %.2f%n", box.calculateLateralSurfaceArea());
            System.out.printf("Volume – %.2f%n", box.calculateVolume());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }
}
