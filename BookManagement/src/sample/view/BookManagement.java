package sample.view;

import sample.controllers.AuthorList;
import sample.dto.I_List;
import sample.dto.I_Menu;
import sample.controllers.Menu;
import sample.controllers.BookList;
import sample.dto.IAuthorList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hoa Doan
 */
public class BookManagement {

    public static void main(String args[]) {
        I_Menu menu = new Menu();
        menu.addItem("1. Show the book list");
        menu.addItem("2. Add new book");
        menu.addItem("3. Update a book");
        menu.addItem("4. Delete book");
        menu.addItem("5: Search book");
        menu.addItem("6. Save");
        menu.addItem("7. Quit");
        int choice;
        boolean quit;
        IAuthorList listAuthor = new AuthorList();
        I_List list = new BookList(listAuthor);
        do {
            menu.showMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    list.showTheBookList();
                    break;
                case 2:
                    list.addNewBook();
                    break;
                case 3:
                    list.updateBook();
                    break;
                case 4:
                    list.deleteBook();
                    break;
                case 5:
                    list.searchBook();
                    break;
                case 6:
                    list.saveToFile();
                    break;
                case 7:
                    quit = menu.confirmYesNo("Do you want to quit?(Y/N)");
                    if (quit) {
                        return;
                    }
                    break;
            }
        } while (choice >= 1 && choice <= 7);
    }
}
