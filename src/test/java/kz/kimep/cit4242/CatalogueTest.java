package kz.kimep.cit4242;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CatalogueTest {

    @Test
    void loadsAllBooksFromCsv() {
        Catalogue catalogue = new Catalogue("books.csv");
        assertEquals(5, catalogue.size());
    }

    @Test
    void findsBookByTitle() {
        Catalogue catalogue = new Catalogue("books.csv");
        assertEquals(464, catalogue.findByTitle("clean code").orElseThrow().getPages());
    }

    @Test
    void returnsOnlyLongBooks() {
        Catalogue catalogue = new Catalogue("books.csv");
        assertEquals(4, catalogue.longBooks().size());
    }
}
