package hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Hotel {
    private String name;
    private int capacity;
    private List<Person> persons;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.persons = new ArrayList<>();
    }

    public void add(Person person){
        if(getCount() < capacity){
            persons.add(person);
        }
    }

    public boolean remove(String name){
        Person person = persons.stream().filter(x -> x.getName().equals(name)).findFirst().orElse(null);
        if(person != null){
            persons.remove(person);
            return true;
        }
        return false;
    }

    public Person getPerson(String name, String hometown){
        return persons.stream()
                .filter(x -> x.getName().equals(name))
                .filter(y -> y.getHometown().equals(hometown))
                .findFirst()
                .orElse(null);
    }

    public int getCount(){
        return persons.size();
    }

    public String getStatistics(){
        StringBuilder result = new StringBuilder();
        result.append(String.format("The people in the hotel %s are:%n", name));
        for (Person person:persons){
            result.append(String.format("%s%n", person));
        }
        return result.toString();
    }
}
