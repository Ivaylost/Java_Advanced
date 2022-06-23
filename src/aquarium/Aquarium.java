package aquarium;

import java.util.*;

public class Aquarium {
    private String name;
    private int capacity;
    private int size;
    private List<Fish> fishInPool;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public void add(Fish fish){
        boolean match = fishInPool.stream().anyMatch(x -> x.getName().equals(fish.getName()));
        if(!match && capacity > fishInPool.size()) {
            fishInPool.add(fish);
        }
    }

    public boolean remove(String name) {
        Fish fish = fishInPool.stream().filter(x -> x.getName().equals(name)).findFirst().orElse(null);
        if(fish != null){
            fishInPool.remove(fish);
            return true;
        }
        return false;
    }

    public Fish findFish(String name){
        return fishInPool.stream().filter(x -> x.getName().equals(name)).findFirst().orElse(null);
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Aquarium: %s ^ Size: %d%n", name, size));
        for(Fish fish : fishInPool){
            sb.append(String.format("%s%n", fish));
        }
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public List<Fish> getFishInPool() {
        return fishInPool;
    }
}
