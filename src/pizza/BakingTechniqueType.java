package pizza;

public enum BakingTechniqueType {
    Crispy(0.9),
    Chewy(1.1),
    Homemade(1.0);

    private double rank;

    BakingTechniqueType(double rank) {
        this.rank = rank;
    }

    public double getRank() {
        return rank;
    }
}
