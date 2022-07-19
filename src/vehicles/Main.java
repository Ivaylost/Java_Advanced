package vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] carParam = sc.nextLine().split("\\s+");
        String[] truckParam = sc.nextLine().split("\\s+");

        Car car = new Car(Double.parseDouble(carParam[1]), Double.parseDouble(carParam[2]));
        Truck truck = new Truck(Double.parseDouble(truckParam[1]), Double.parseDouble(truckParam[2]));
        
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] command = sc.nextLine().split("\\s+");
            if ("Drive".equals(command[0])){
                switch (command[1]){
                    case "Car":
                        System.out.println(car.driving(command[2]));
                        break;
                    case "Truck":
                        System.out.println(truck.driving(command[2]));
                        break;
                }
            }

            if ("Refuel".equals(command[0])){
                switch (command[1]){
                    case "Car":
                        car.refueling(Double.parseDouble(command[2]));
                        break;
                    case "Truck":
                        truck.refueling(Double.parseDouble(command[2]));
                        break;
                }
            }
        }

        System.out.printf("Car: %.2f%n", car.fuelQuantity);
        System.out.printf("Truck: %.2f%n", truck.fuelQuantity);
    }
}
