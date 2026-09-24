package kz.kimep.cit4242;

import java.util.List;

/** A book source that never touches the disk. Useful in tests. */
public class InMemoryBookSource implements BookSource {

    @Override
    public List<Book> load() {
        return List.of(
                new Book("Clean Code", "Robert C. Martin", 464),
                new Book("Effective Java", "Joshua Bloch", 412),
                new Book("Java in a Nutshell", "Benjamin Evans", 350)
        );
    }
}
