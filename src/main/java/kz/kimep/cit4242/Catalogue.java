package kz.kimep.cit4242;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Catalogue {
    private final List<Book> books;

    public Catalogue(String resource) {
        this.books = List.copyOf(loadCsv(resource));
    }

    private static List<Book> loadCsv(String resource) {
        InputStream in = Catalogue.class.getClassLoader().getResourceAsStream(resource);
        if (in == null) {
            throw new IllegalArgumentException("Resource not found: " + resource);
        }
        List<Book> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))) {
            String line = reader.readLine(); // skip header
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] parts = line.split(",");
                result.add(new Book(parts[0].trim(), parts[1].trim(), Integer.parseInt(parts[2].trim())));
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return result;
    }

    public List<Book> all() { return books; }

    public int size() { return books.size(); }

    public Optional<Book> findByTitle(String title) {
        return books.stream().filter(b -> b.getTitle().equalsIgnoreCase(title)).findFirst();
    }

    public List<Book> longBooks() {
        return books.stream().filter(Book::isLong).toList();
    }
}
