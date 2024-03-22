package sample.dto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hoa Doan
 */
public class Book {

    private String id;
    private String isbn;
    private String title;
    private Double price;
    private String authorId;

    public Book() {
    }

    public Book(String id, String isbn, String title, Double price, String authorId) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.price = price;
        this.authorId = authorId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return id + ", " + isbn + ", " + title + ", " + price + ", " + authorId;
    }
    
    
    

}
