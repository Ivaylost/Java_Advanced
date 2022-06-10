package OOP_Exercise.SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<String, Car> cars = new LinkedHashMap<>();


        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");
            String model = input[0];
            double fuel = Double.parseDouble(input[1]);
            double cost = Double.parseDouble(input[2]);
            cars.put(model, new Car(model, fuel, cost));
        }

        String[] tokens = sc.nextLine().split("\\s+");
        while (!tokens[0].equals("End")){
            String model = tokens[1];
            int kilometers = Integer.parseInt(tokens[2]);
            Car car = cars.get(model);
            if(car.hesEnoughFuel(kilometers)){
                car.drive(kilometers);
            } else {
                System.out.println("Insufficient fuel for the drive");
            }
            tokens = sc.nextLine().split("\\s+");
        }

        cars.values()
                .forEach(System.out::println);
    }
}
