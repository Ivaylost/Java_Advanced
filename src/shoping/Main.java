package shoping;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Person> persons = new LinkedHashMap<>();
        Map<String, Product> products = new HashMap<>();

        String[] per = sc.nextLine().split(";");
        for (String p : per) {
            String[] x = p.split("=");
            String name = x[0];
            double m = Double.parseDouble(x[1]);
            try {
                Person person = new Person(name, m);
                persons.put(name,person);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        String[] prod = sc.nextLine().split(";");
        for (String p : prod) {
            String[] x = p.split("=");
            String name = x[0];
            double m = Double.parseDouble(x[1]);
            try {
                Product product = new Product(name, m);
                products.put(name,product);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        String command = sc.nextLine();

        while (!"END".equals(command)){
            String[] split = command.split(" ");
            Person p = persons.get(split[0]);
            Product pr = products.get(split[1]);
            try {
                p.buyProduct(pr);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }


            command = sc.nextLine();
        }

        persons.values().forEach(System.out::println);
    }
}
