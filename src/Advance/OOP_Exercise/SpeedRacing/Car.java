package Advance.OOP_Exercise.SpeedRacing;

public class Car {
    String model;
    double fuel;
    double cost;
    int kilometers;

    public Car(String model, double fuel, double cost) {
        this.model = model;
        this.fuel = fuel;
        this.cost = cost;
        this.kilometers = 0;
    }

    public void drive(int kilometers){
        this.kilometers += kilometers;
        this.fuel -= this.cost*kilometers;
    }

    public boolean hesEnoughFuel(int kilometers){
        return this.cost*kilometers <= this.fuel;
    }

    public String getModel() {
        return model;
    }

    public double getFuel() {
        return fuel;
    }

    public double getCost() {
        return cost;
    }

    public int getKilometers() {
        return kilometers;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuel, this.kilometers);
    }
}
