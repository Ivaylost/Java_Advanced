package hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Hotel {
    private String name;
    private int capacity;
    private List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person){
        if(getCount() < capacity){
            roster.add(person);
        }
    }

    public boolean remove(String name){
        return roster.removeIf(person -> person.getName().equals(name));
    }

    public Person getPerson(String name, String hometown){
        return roster.stream()
                .filter(x -> x.getName().equals(name))
                .filter(y -> y.getHometown().equals(hometown))
                .findFirst()
                .orElse(null);
    }

    public int getCount(){
        return roster.size();
    }

    public String getStatistics(){
        StringBuilder result = new StringBuilder();
        result.append(String.format("The people in the hotel %s are:%n", name));
        for (Person person:roster){
            result.append(String.format("%s%n", person));
        }
        return result.toString();
    }
}
