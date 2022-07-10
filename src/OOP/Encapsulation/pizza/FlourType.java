package OOP.Encapsulation.pizza;

public enum FlourType {

    White(1.5),
    Wholegrain(1.0);

    private double rank;

    FlourType(double rank) {
        this.rank = rank;
    }

    public double getRank() {
        return rank;
    }
}
