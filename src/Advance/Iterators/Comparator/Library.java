package Advance.Iterators.Comparator;

import java.util.Arrays;
import java.util.Iterator;

public class Library implements Iterable<Book>{
    Book[] books;

    public Library(Book... books) {
        this.books = books;
    }

    @Override
    public Iterator<Book> iterator() {
        return Arrays.stream(books).iterator();
    }


//    @Override
//    public Iterator<Book> iterator() {
//        return new Iterator<>() {
//            private int index = 0;
//
//            @Override
//            public boolean hasNext() {
//                return index < books.length;
//            }
//
//            @Override
//            public Book next() {
//                return books[index++];
//            }
//        };
//    }
}
