package sample.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author USER
 */
import java.util.ArrayList;
import sample.dto.I_Menu;
import sample.utils.Utils;

public class Menu extends ArrayList<String> implements I_Menu {

    public Menu() {
        super();
    }
    // must implement all abstract method of I_Menu interface

    @Override
    public void addItem(String s) {
        this.add(s);
    }

    @Override
    public void showMenu() {
        System.out.println("Vehicle menu"); //To change body of generated methods, choose Tools | Templates.
        this.forEach((menuString) -> {
            System.out.println(menuString);
        });
    }

    @Override
    public boolean confirmYesNo(String welcome) {
        System.out.println(welcome); //To change body of generated methods, choose Tools | Templates.
        String choice = Utils.getString("Select: ");

        return choice.equalsIgnoreCase("y");
    }

    @Override
    public int getChoice() {
        return Utils.getInt("Select: ", 1, 10);
        //To change body of generated methods, choose Tools | Templates.
    }

}
