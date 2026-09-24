package kz.kimep.cit4242;

import java.util.List;

/** Where books come from. Catalogue depends on this, not on a file. */
public interface BookSource {
    List<Book> load();
}
