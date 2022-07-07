package shoping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        products = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setMoney(double money) {
        if(money < 0){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void buyProduct (Product product){
        if (money < product.getCost()){
            throw new IllegalArgumentException(String.format("%s can't afford %s", name, product.getName()));
        }
        products.add(product);
        money -= product.getCost();
        System.out.printf("%s bought %s%n", name, product.getName());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name + " - ");
        if (products.isEmpty()){
            sb.append("Nothing bought");
        } else {
            List<String> pr = products.stream().map(x -> x.getName()).collect(Collectors.toList());
            sb.append(String.join(", ", pr));
        }

        return sb.toString();
    }
}
