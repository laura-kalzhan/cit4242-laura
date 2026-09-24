package kz.kimep.cit4242;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CatalogueTest {

    @Test
    void loadsAllBooksFromCsv() {
        Catalogue catalogue = new Catalogue(new CsvBookSource("books.csv"));
        assertEquals(5, catalogue.size());
    }

    @Test
    void findsBookByTitle() {
        Catalogue catalogue = new Catalogue(new InMemoryBookSource());
        assertEquals(464, catalogue.findByTitle("clean code").orElseThrow().pages());
    }

    @Test
    void returnsOnlyLongBooks() {
        Catalogue catalogue = new Catalogue(new InMemoryBookSource());
        assertEquals(2, catalogue.longBooks().size());
    }
}
