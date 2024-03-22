package sample.view;

import sample.dto.I_List;
import sample.dto.I_Menu;
import sample.controllers.Menu;
import sample.controllers.VehicleList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hoa Doan
 */
public class VehicleManagement {

    public static void main(String args[]) {
        I_Menu menu = new Menu();
        menu.addItem("1.Add new vehicle");
        menu.addItem("2.Check to exist vehicle");
        menu.addItem("3.Update a vehicle");
        menu.addItem("4.Remove a vehicle");
        menu.addItem("5.Search vehicle");
        menu.addItem("6.Display vehicle list");
        menu.addItem("7.Save data to file");
        menu.addItem("8.Print vehicle list");
        menu.addItem("9. Print vehicle in mid of list");
        menu.addItem("10:Quit");
        int choice;
        boolean quit;
        I_List list = new VehicleList();
        do {
            menu.showMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    list.addNewVehicle();
                    break;
                case 2:
                    list.checkToExistVehicle();
                    break;
                case 3:
                    list.update();
                    break;
                case 4:
                    list.remove();
                    break;
                case 5:
                    list.searchVehicle();
                    break;
                case 6:
                    list.printVehicleList();
                    break;
                case 7:
                    list.saveToFile();
                    break;
                case 8:
                    list.printVehicleList();
                    break;
                case 9:
                    list.printMidVehicle();
                    break;
                case 10:
                    quit = menu.confirmYesNo("Do you want to quit?(Y/N)");
                    if (quit) {
                        return;
                    }
                    break;
            }
        } while (choice >= 1 && choice <= 10);
    }
}
