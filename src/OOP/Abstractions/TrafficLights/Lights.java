package OOP.Abstractions.TrafficLights;

public enum Lights {
    RED, GREEN, YELLOW;

    private static final Lights[] lightValues = values();

    public Lights next(){
        return lightValues[(this.ordinal()+1)%lightValues.length];
    }
}
