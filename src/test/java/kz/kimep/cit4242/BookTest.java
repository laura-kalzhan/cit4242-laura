package kz.kimep.cit4242;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void equalBooksHaveEqualHashCodes() {
        Book x = new Book("Clean Code", "Robert C. Martin", 464);
        Book y = new Book("Clean Code", "Robert C. Martin", 464);
        assertNotSame(x, y);                       // x == y is false
        assertEquals(x, y);                        // equals compares components
        assertEquals(x.hashCode(), y.hashCode());  // hashCode agrees with equals
    }

    @Test
    void hashSetFindsEqualBook() {
        Set<Book> set = new HashSet<>();
        set.add(new Book("Clean Code", "Robert C. Martin", 464));
        set.add(new Book("Clean Code", "Robert C. Martin", 464));
        assertEquals(1, set.size());
        assertTrue(set.contains(new Book("Clean Code", "Robert C. Martin", 464)));
    }

    @Test
    void toStringShowsComponents() {
        Book b = new Book("Clean Code", "Robert C. Martin", 464);
        assertTrue(b.toString().contains("464"));
    }

    @Test
    void isLongUsesFourHundredPageThreshold() {
        assertTrue(new Book("A", "X", 401).isLong());
        assertFalse(new Book("B", "Y", 400).isLong());
    }
}
