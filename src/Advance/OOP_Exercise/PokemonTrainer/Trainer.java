package Advance.OOP_Exercise.PokemonTrainer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Trainer {
    private String name;
    private int badges;
    private List<Pokemon> pokes;

    public Trainer(String name) {
        this.name = name;
        this.badges = 0;
        this.pokes = new ArrayList<>();
    }

    public boolean containsElement(String element){
        return  pokes.stream()
                .anyMatch(x -> x.getElement().equals(element));
    }

    public String getName() {
        return name;
    }

    public int getBadges() {
        return badges;
    }

    public List<Pokemon> getPokes() {
        return pokes;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    public void increaseBadge(){
        this.badges++;
    }

    private int getPokesNumber(){
        return this.pokes.stream().filter(x -> x.getHealth() > 0)
                .collect(Collectors.toList()).size();
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.getName(), badges, getPokesNumber());
    }
}
