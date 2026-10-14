package in.prathamattri.testbookapi.entity;

import lombok.*;

@Getter
@Setter
public class Book {
    static int BOOK_ID = 0;
    {
        this.id = ++BOOK_ID;
    }
    @Setter(AccessLevel.NONE)
    private int id;
    private String title;
    private String author;
    private double price;

    public  Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
}
