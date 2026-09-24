package kz.kimep.cit4242;

import java.util.Objects;

public final class Book {
    private final String title;
    private final String author;
    private final int pages;

    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getPages() { return pages; }

    public boolean isLong() { return pages > 400; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book other)) return false;
        return pages == other.pages
                && Objects.equals(title, other.title)
                && Objects.equals(author, other.author);
    }

    @Override
    public int hashCode() { return Objects.hash(title, author, pages); }

    @Override
    public String toString() {
        return "Book[title=" + title + ", author=" + author + ", pages=" + pages + "]";
    }
}
