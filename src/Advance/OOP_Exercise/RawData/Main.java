package Advance.OOP_Exercise.RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");
            String model = input[0];
            int speed = Integer.parseInt(input[1]);
            int power = Integer.parseInt(input[2]);
            int weight = Integer.parseInt(input[3]);
            String type = input[4];
            List<Tire> tyres = new ArrayList<>();
            for (int j = 5; j <= 12 ; j = j+2) {
                double pressure = Double.parseDouble(input[j]);
                int age = Integer.parseInt(input[j+1]);
                tyres.add(new Tire(age, pressure));
            }
            Car car = new Car(model,new Engine(speed, power),new Cargo(weight,type),tyres);
            cars.add(car);
        }
        String command = sc.nextLine();
        if (command.equals("fragile")){
            cars.stream()
                    .filter(x -> x.getCargo().getType().equals("fragile"))
                    .filter(x ->x.getTires().stream().anyMatch(y -> y.getPressure() < 1.0))
                    .forEach(x -> System.out.println(x.getModel()));
        } else {
            cars.stream()
                    .filter(x -> x.getCargo().getType().equals("flamable"))
                    .filter(x -> x.getEngine().getPower() > 250)
                    .forEach(x -> System.out.println(x.getModel()));
        }
    }
}
