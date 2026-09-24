package kz.kimep.cit4242;

/**
 * A book in the catalogue. The record generates the constructor,
 * the accessors title(), author() and pages(), and equals, hashCode
 * and toString, all consistent with each other.
 */
public record Book(String title, String author, int pages) {

    /** A decision, not bookkeeping: more than 400 pages counts as long. */
    public boolean isLong() {
        return pages > 400;
    }
}
