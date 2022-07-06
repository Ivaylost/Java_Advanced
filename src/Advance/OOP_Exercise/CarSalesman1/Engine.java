package Advance.OOP_Exercise.CarSalesman1;

public class Engine {
    // "{Model} {Power} {Displacement} {Efficiency}
    private String model;
    private int power;
    private int displacement; //optional
    private String efficiency; //optional

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
        this.displacement = -1;
        this.efficiency = "n/a";
    }

    public Engine(String model, int power, int displacement) {
        this(model, power);
        this.displacement = displacement;
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power);
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, int displacement, String efficiency) {
        this(model, power);
        this.efficiency = efficiency;
        this.displacement = displacement;
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public String getDisplacement() {
        return displacement > -1 ? String.valueOf(this.displacement) : "n/a";
    }

    public String getEfficiency() {
        return efficiency;
    }

    @Override
    public String toString() {
        return String.format(this.model+":%n"
                +"Power: "+this.power+"%n"
                +"Displacement: "+this.getDisplacement()+"%n"
                +"Efficiency: "+this.efficiency+"%n"
        );
    }
}

