package pl.smerski.zad5;

import lombok.Getter;
import lombok.Setter;

public class Book {
    @Getter @Setter
    private String name;
    @Getter @Setter
    private Author author;
    @Getter @Setter
    private double price;
    @Getter @Setter
    private int qty = 0;

    public Book(){
        this.name = "";
        this.author = new Author();
        this.price = 0;
        this.qty = 0;
    }
    public Book(String name, Author author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public Book(String name, Author author, double price, int qty) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.qty = qty;
    }
    public String toString(){
        return "Book[" + getName() + "," + this.author.toString() + "," + getPrice() + "," + getQty() + "]";
    }
}
