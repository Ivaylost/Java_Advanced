package OOP.Inheritance.needForSpeed;

public class Car extends Vehicle{
    final static double DEFAULT_FUEL_CONSUMPTION = 3;

    public Car(double fuelConsumption, int horsePower) {
        super(fuelConsumption, horsePower);
        super.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }


}
