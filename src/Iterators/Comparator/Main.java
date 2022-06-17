package Iterators.Comparator;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookThree = new Book("The Documents in the Case", 2002);
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");

        List<Book> books = new ArrayList<>();
        books.add(bookOne);
        books.add(bookTwo);
        books.add(bookThree);

        books.sort(new BookComparator());

        TreeSet<Book> books1 = new TreeSet<>(new BookComparator()); //-----!!!------

        for (Book book: books) {
            System.out.println(book.getTitle() + book.getYear());
        }

        books.stream()
                .sorted((f, s) -> Integer.compare(f.getAuthors().size(), s.getAuthors().size()))
                .forEach(System.out::println);
    }
}
