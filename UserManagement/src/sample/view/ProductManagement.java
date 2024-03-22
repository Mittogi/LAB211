package sample.view;

import sample.dto.I_List;
import sample.dto.I_Menu;
import sample.controllers.Menu;
import sample.controllers.UsertList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hoa Doan
 */
public class ProductManagement {

    public static void main(String args[]) throws Exception {
        I_Menu menu = new Menu();
        menu.addItem("1. Add new user");
        menu.addItem("2. Find user");
        menu.addItem("3. Search user information by name");
        menu.addItem("4. Remove a user");
        menu.addItem("5. Update a user");
        menu.addItem("6. Print all list from file");
        menu.addItem("7. Save file");
        menu.addItem("8: Quit");
        menu.addItem("9.Get first user");
        int choice;
        boolean quit;
        I_List list = new UsertList();
        do {
            menu.showMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    list.addUser();
                    break;
                case 2:
                    list.findUserInFile();
                    break;
                case 3:
                    list.searchUserInformationByName();
                    break;
                case 4:
                    list.remove();
                    break;
                case 5:
                    list.update();
                    break;
                case 6:
                    list.printAllListFromFile();
                    break;
                case 7:
                    list.saveFile();
                    break;
                case 8:
                    quit = menu.confirmYesNo("Do you want to quit?(Y/N)");
                    if (quit) {
                        return;
                    }
                    break;
                case 9:
                    list.getFirstUser();
            }
        } while (choice >= 0 && choice <= 9);
    }
}
