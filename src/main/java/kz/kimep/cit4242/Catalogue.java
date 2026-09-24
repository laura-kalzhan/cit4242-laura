package kz.kimep.cit4242;

import java.util.List;
import java.util.Optional;

public class Catalogue {
    private final List<Book> books;

    public Catalogue(BookSource source) {
        this.books = List.copyOf(source.load());
    }

    public List<Book> all() { return books; }

    public int size() { return books.size(); }

    public Optional<Book> findByTitle(String title) {
        return books.stream().filter(b -> b.title().equalsIgnoreCase(title)).findFirst();
    }

    public List<Book> longBooks() {
        return books.stream().filter(Book::isLong).toList();
    }
}
