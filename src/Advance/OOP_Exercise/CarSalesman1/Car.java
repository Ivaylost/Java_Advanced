package Advance.OOP_Exercise.CarSalesman1;

public class Car {
    // "{Model} {Engine} {Weight} {Color}"
    private String model;
    private Engine engin;
    private int weight;
    private String color;

    public Car(String model) {
        this.model = model;
        this.weight = -1;
        this.color = "n/a";
    }

    public Car(String model, int weight) {
        this(model);
        this.weight = weight;
    }

    public Car(String model, String color) {
        this(model);
        this.color = color;
    }

    public Car(String model, int weight, String color) {
        this(model, weight);
        this.color = color;
    }

    public void setEngin(Engine engin) {
        this.engin = engin;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngin() {
        return engin;
    }

    public String getWeight() {
        return this.weight == -1 ? "n/a" : String.valueOf(this.weight);
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return String.format(this.model+":%n"
                +this.engin
                +"Weight: "+this.getWeight()+"%n"
                +"Color: "+this.color
        );
    }
}
