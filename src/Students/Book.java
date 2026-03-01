package Students;

import java.util.Objects;

public class Book {
    private String title;
    private int pages;
    private int year;

    public Book(String title, int pages, int year){
        this.title = title;
        this.pages = pages;
        this.year = year;
    }

    public String getTitle() {return title;}

    public int getPages() {return pages;}

    public int getYear() {return year;}



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Students.Book book = (Students.Book) o;
        return pages == book.pages &&
                year == book.year &&
                Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, pages, year);
    }

    @Override
    public String toString() {
        return String.format("'%s' (%d стр., %d г.)", title, pages, year);
    }

}
