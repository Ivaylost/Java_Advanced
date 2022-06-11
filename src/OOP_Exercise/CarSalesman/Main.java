package OOP_Exercise.CarSalesman;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfEngines = Integer.parseInt(sc.nextLine());
        Map<String, Engine> engines = new LinkedHashMap<>();
        for (int i = 0; i < numberOfEngines; i++) {
            String[] input = sc.nextLine().split("\\s+");
            String model = input[0];
            int power = Integer.parseInt(input[1]);
            if(input.length == 4){
                 int displacement = Integer.parseInt(input[2]);
                 String efficiency = input[3];
                 engines.put(model, new Engine(model, power, displacement, efficiency));
            } else if(input.length == 3){
                if (input[2].matches("\\d+")){
                    int displacement = Integer.parseInt(input[2]);
                    engines.put(model, new Engine(model, power, displacement));
                } else {
                    String efficiency = input[2];
                    engines.put(model, new Engine(model, power, efficiency));
                }
            } else {
                engines.put(model, new Engine(model, power));
            }
        }
        //"{Model} {Engine} {Weight} {Color}"
        int numberOfCars = Integer.parseInt(sc.nextLine());
        Map<String, Car> cars = new LinkedHashMap<>();
        for (int i = 0; i < numberOfCars; i++) {
            String[] input = sc.nextLine().split("\\s+");
            String model = input[0];
            String enginString = input[1];
            Engine engin = engines.get(enginString);
            if(input.length == 4){
                int weight = Integer.parseInt(input[2]);
                String color = input[3];
                Car car = new Car(model, weight, color);
                car.setEngin(engin);
                cars.put(model, car);
            } else if(input.length == 3){
                if (input[2].matches("\\d+")){
                    int weight = Integer.parseInt(input[2]);
                    Car car = new Car(model, weight);
                    car.setEngin(engin);
                    cars.put(model, car);
                } else {
                    String color = input[2];
                    Car car = new Car(model, color);
                    car.setEngin(engin);
                    cars.put(model, car);
                }
            } else {
                Car car = new Car(model);
                car.setEngin(engin);
                cars.put(model, car);
            }
        }

        cars.values().forEach(System.out::println);
    }
}
