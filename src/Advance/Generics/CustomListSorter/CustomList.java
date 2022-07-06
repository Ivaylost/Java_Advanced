package Advance.Generics.CustomListSorter;

import java.util.ArrayList;
import java.util.List;

public class CustomList <T extends Comparable<T>> {
    private final List<T> list;

    public CustomList() {
        this.list = new ArrayList<>();
    }

    public List<T> getList() {
        return list;
    }

    public void add(T element){
        list.add(element);
    }

    public T remove(int index){
        return list.remove(index);
    }

    public boolean contains(T element){
        return list.contains(element);
    }

    public void swap(int firstIndex, int lastIndex){
        T first = list.get(firstIndex);
        T last = list.get(lastIndex);
        list.set(firstIndex, last);
        list.set(lastIndex, first);
    }

    public int size(){
        return list.size();
    }

    public T get(int index){
        return list.get(index);
    }

    public int countGreaterThen(T element){
        return (int) list.stream().filter(x -> x.compareTo(element) > 0).count();
    }

    public T getMax(){
        return list.stream().max(Comparable::compareTo).orElse(null);
    }

    public T getMin(){
        return list.stream().min(Comparable::compareTo).orElse(null);
    }
}
