package OOP.Abstractions.TrafficLights;

public class TrafficLight {
    private Lights state;

    public TrafficLight(Lights state) {
        this.state = state;
    }

    public Lights getState() {
        return state;
    }

    public void setState(Lights state) {
        this.state = state;
    }
}
