package OOP.Encapsulation.pizza;

import java.util.Arrays;

public class Topping {
    private ToppingsType toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        //Arrays.stream(ToppingsType.values()).map(Enum::name).collect(Collectors.toList()).contains(toppingType)
        if (Arrays.stream(ToppingsType.values()).anyMatch(x->x.name().equals(toppingType))){
            this.toppingType = ToppingsType.valueOf(toppingType);
        } else{
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your OOP.Encapsulation.pizza.", toppingType));
        }

    }

    private void setWeight(double weight) {
        if (weight<1 || weight>50){
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].",toppingType.name()));
        }
        this.weight = weight;
    }

    public double calculateCalories () {
        return 2*weight* toppingType.getRank();
    }
}
