package sample.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hoa Doan
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import sample.dto.I_List;
import sample.dto.Book;
import sample.dto.IAuthorList;
import sample.dto.filemanager.FileManager;
import sample.dto.filemanager.IFileManager;
import sample.utils.Utils;

public class BookList extends ArrayList<Book> implements I_List {

    IFileManager vFileManager;
    IAuthorList listAuthor;

    public BookList(IAuthorList listAuthor) {
        try {
            this.listAuthor = listAuthor;
            vFileManager = new FileManager("book.txt");
            loadDataFromFile(this);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    // Read data
    public void loadDataFromFile(List<Book> listBook) throws Exception {
        for (String raw : vFileManager.readDataFromFile()) {
            listBook.add(convertStringToBook(raw));
        }
    }

    public Book convertStringToBook(String rawString) {
        String id, isbn, title, authorId;
        double price;
        List<String> raw = Arrays.asList(rawString.split(","));

        id = raw.get(0).trim();
        isbn = raw.get(1).trim();
        title = raw.get(2).trim();
        price = Double.parseDouble(raw.get(3).trim());
        authorId = raw.get(4).trim();

        return new Book(id, isbn, title, price, authorId);
    }

    @Override
    public void saveToFile() {
        try {
            List<String> rawList = new ArrayList<>();

            for (Book book : this) {
                String line = book.toString() + "\n";
                rawList.add(line);
            }
            vFileManager.commitFile(rawList);
            System.out.println("Saved!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void showTheBookList() {
        if (this.isEmpty()) {
            System.out.println("Book is empty!");
            return;
        }

        for (Book book : this) {
            System.out.println(book);
        }
    }

    @Override
    public void addNewBook() {
        try {
            Book book = Utils.getNewBook(this, listAuthor);
            this.add(book);
            System.out.println("Create book success!");
            String isCont = Utils.getString("Do you want add new user account?(Y/N): ");

            if (isCont.equalsIgnoreCase("y")) {
                addNewBook();
            }
        } catch (Exception e) {
            System.out.println("Create book fail!");
        }

    }

    @Override
    public void updateBook() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteBook() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void searchBook() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
