package OOP.Encapsulation.pizza;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int num) {
        setName(name);
        setToppings(num);
    }

    private void setName(String name) {
        if (name.trim().isEmpty() || name.length() >15 || name.length() < 1) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        } else {
            this.name = name;
        }
    }

    private void setToppings(int num){
        if (num<0 || num>10){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppings = new ArrayList<>();
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return name;
    }

    public void addTopping (Topping topping) {
        this.toppings.add(topping);
    }

    public double getOverallCalories() {
        return dough.calculateCalories() + toppings.stream().mapToDouble(Topping::calculateCalories).sum();
    }
}
