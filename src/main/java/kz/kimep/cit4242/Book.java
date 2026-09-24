package kz.kimep.cit4242;

public record Book(String title, String author, int pages) {

    public boolean isLong() {
        return pages > 400;
    }
}
