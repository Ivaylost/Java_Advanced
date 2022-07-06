package Advance.IteratorsExcercise.ListyIterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
    private List<String> list;
    private int index;

    public ListyIterator(String... args) {
        this.index = 0;
        this.list = Arrays.asList(args);
    }

    public boolean move() {
        if(hasNext()) {
            index ++;
            return true;
        }
        return false;
    }

    public void print() {
        if(list.size() > 0) {
            System.out.println(list.get(index));
        } else {
            throw new IllegalArgumentException("Invalid Operation!");
        }
    }

    public boolean hasNext() {
        if(index < list.size()-1) {
            return true;
        }
        return false;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index;

            @Override
            public boolean hasNext() {
                return index < list.size();
            }

            @Override
            public String next() {
                String element = list.get(index);
                index++;
                return element;
            }
        };
    }
}
