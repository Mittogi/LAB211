/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.utils;

import java.util.List;
import sample.dto.Vehicle;

/**
 *
 * @author vopha
 */
public class DataValidation {

    public static boolean checkDuplicate(String string, List<Vehicle> listUser) {
        for (Vehicle vehicle : listUser) {
            if (vehicle.getId().equals(string)) {
                return true;
            }
        }

        return false;
    }

    public static boolean checkMatches(String string, String pattern) {
        return string.matches(pattern);
    }

//------------------------------------------------------------------------------
    public static boolean checkNewId(String id, List<Vehicle> listVehicle) {
        if (!checkMatches(id, "\\d{5}")) {
            System.out.println("Id invalid. The correct id is xxxxx with x is digit!");
            return false;
        }

        if (checkDuplicate(id, listVehicle)) {
            System.out.println("Id is duplicate!");
            return false;
        }

        return true;
    }
}
