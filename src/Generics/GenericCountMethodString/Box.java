package Generics.GenericCountMethodString;

public class Box<T extends Comparable> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.getClass().getName() + ": " + value;
    }
}
