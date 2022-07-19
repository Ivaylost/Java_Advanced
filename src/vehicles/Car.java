package vehicles;

public class Car extends Vehicle{

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + 0.9);
    }

    @Override
    public String driving(String km) {
        double consumption = Double.parseDouble(km) * super.fuelConsumption;
        if(super.fuelQuantity >= consumption){
            super.fuelQuantity -= consumption;
            return String.format("Car travelled %s km", km);
        }
        return "Car needs refueling";
    }

    @Override
    public void refueling(double liters) {
       super.fuelQuantity += liters;
    }
}
