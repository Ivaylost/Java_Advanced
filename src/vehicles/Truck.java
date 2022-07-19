package vehicles;

public class Truck extends Vehicle{

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + 1.6);
    }

    @Override
    public String driving(String km) {
        double consumption = Double.parseDouble(km) * super.fuelConsumption;
        if(super.fuelQuantity >= consumption){
            super.fuelQuantity -= consumption;
            return String.format("Truck travelled %s km", km);
        }
        return "Truck needs refueling";
    }

    @Override
    public void refueling(double liters) {
        super.fuelQuantity += 0.95*liters;
    }
}
