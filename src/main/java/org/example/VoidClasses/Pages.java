package org.example.VoidClasses;

public class Pages {
    private Book book;
    public Pages(Book book) {
        this.book = book;
    }
    public int numberOfPages() {
        try {
            book.lessonsOfBook();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return 1;
    }
}
