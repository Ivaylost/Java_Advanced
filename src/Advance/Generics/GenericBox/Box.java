package Advance.Generics.GenericBox;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> values ;

    public Box() {
        this.values = new ArrayList<>();
    }

    public void add(T value){
        values.add(value);
    }

    public long getGreaterElements(T element){
        return values.stream()
                .filter(x -> x.compareTo(element) > 0).count();
    }

    public void swap(int indexFirst, int indexLast){
        T first = values.get(indexFirst);
        T last = values.get(indexLast);
        values.set(indexFirst, last);
        values.set(indexLast, first);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (T value : values){
            String x = String.format("%s: %s%n", value.getClass().getName(), value.toString());
            result.append(x);
        }

        return result.toString();
    }
}
