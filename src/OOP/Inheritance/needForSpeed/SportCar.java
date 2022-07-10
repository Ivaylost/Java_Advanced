package OOP.Inheritance.needForSpeed;

public class SportCar extends Car{
    final static double DEFAULT_FUEL_CONSUMPTION = 10;

    public SportCar(double fuelConsumption, int horsePower) {
        super(fuelConsumption, horsePower);
        super.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
