package pizza;

public enum ToppingsType {
    Meat(1.2),
    Veggies(0.8),
    Cheese(1.1),
    Sauce(0.9);

    private double rank;

    ToppingsType(double rank) {
        this.rank = rank;
    }

    public double getRank() {
        return rank;
    }
}
