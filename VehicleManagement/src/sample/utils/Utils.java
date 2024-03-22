/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import sample.dto.Vehicle;

/**
 *
 * @author hd
 */
public class Utils {

    public static String getString(String welcome) {
        boolean check = true;
        String result = "";
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print(welcome);
            result = sc.nextLine().trim().toUpperCase();
            if (result.isEmpty()) {
                System.out.println("Input text!!!");
            } else {
                check = false;
            }
        } while (check);
        return result;
    }

    public static String getString(String welcome, String oldData) {
        String result = oldData;
        Scanner sc = new Scanner(System.in);
        System.out.print(welcome);
        String tmp = sc.nextLine().trim().toUpperCase();
        if (!tmp.isEmpty()) {
            result = tmp;
        }
        return result;
    }

    public static int getInt(String welcome, int min, int max) {
        boolean check = true;
        int number = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(welcome);
                number = Integer.parseInt(sc.nextLine().trim());
                check = false;
                if (number > max || number < min) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Input number!!!");
            }
        } while (check || number > max || number < min);
        return number;
    }

    public static int getInt(String welcome, int min, int max, int oldData) {
        boolean check = true;
        int number = oldData;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(welcome);
                String tmp = sc.nextLine().trim();
                if (tmp.isEmpty()) {
                    check = false;
                } else {
                    number = Integer.parseInt(tmp);
                    if (number > max || number < min) {
                        throw new Exception();
                    }
                    check = false;
                }
            } catch (Exception e) {
                System.out.println("Input number!!!");
            }
        } while (check || number > max || number < min);
        return number;
    }

    public static Double getDouble(String welcome, Double min, Double max) {
        boolean check = true;
        Double number = 0.0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(welcome);
                number = Double.parseDouble(sc.nextLine().trim());
                if (number > max || number < min) {
                    throw new Exception();
                }
                check = false;
            } catch (Exception e) {
                System.out.println("Input number!!!");
            }
        } while (check || number > max || number < min);
        return number;
    }

    public static Double getDouble(String welcome, Double min, Double max, Double oldData) {
        boolean check = true;
        Double number = oldData;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(welcome);
                String tmp = sc.nextLine().trim();
                if (tmp.isEmpty()) {
                    check = false;
                } else {
                    number = Double.parseDouble(tmp);
                    if (number > max || number < min) {
                        throw new Exception();
                    }
                    check = false;
                }
            } catch (Exception e) {
                System.out.println("Input number!!!");
            }
        } while (check || number > max || number < min);
        return number;
    }

    public static boolean confirmYesNo(String welcome) {
        boolean result = false;
        String confirm = Utils.getString(welcome);
        if ("Y".equalsIgnoreCase(confirm)) {
            result = true;
        }
        return result;
    }

    public static Vehicle getVehicleById(String id, List<Vehicle> listVehicle) {
        Vehicle vehicle = null;

        for (Vehicle vehicleEmp : listVehicle) {
            if (vehicleEmp.getId().equals(id)) {
                vehicle = vehicleEmp;
            }
        }

        return vehicle;
    }
    
    public static List<Vehicle> getVehicleByContainName(String name, List<Vehicle> listVehicle) {
        List<Vehicle> listVehicleResult = new ArrayList<>();
        
        for (Vehicle vehicle : listVehicle) {
            if (vehicle.getName().contains(name)) {
                listVehicleResult.add(vehicle);
            }
        }
        
        return listVehicleResult;
    }

//------------------------------------------------------------------------------
    public static Vehicle getNewVehicle(List<Vehicle> listVehicle) {
        String id, name, color, brand, type;
        Double price;
        int year;

        do {
            id = getString("Enter vehicle's id: ");
        } while (!DataValidation.checkNewId(id, listVehicle));

        name = getString("Enter vehicle's name: ");
        color = getString("Enter vehicle's color: ");
        price = getDouble("Enter vehicle's price: ", 0.0, Double.MAX_VALUE);
        brand = getString("Enter vehicle's brand: ");
        type = getString("Enter vehicle's type: ");
        year = getInt("Enter vehicle's year: ", 1950, 2023);

        Vehicle newVehicle = new Vehicle(id, name, color, price, brand, type, year);
        return newVehicle;
    }

    public static void getInfoForUpdate(Vehicle vehicle) {
        String name, color, brand, type;
        Double price;
        int year;
        
        name = getString("Enter new name: ", vehicle.getName());
        color = getString("Enter new color: ", vehicle.getColor());
        price = getDouble("Enter new price: ", 0.0, Double.MAX_VALUE, vehicle.getPrice());
        brand = getString("Enter new brand: ", vehicle.getBrand());
        type = getString("Enter new type: ", vehicle.getType());
        year = getInt("Enter new year: ", 1950, 2023, vehicle.getYear());
        
        vehicle.setName(name);
        vehicle.setColor(color);
        vehicle.setPrice(price);
        vehicle.setBrand(brand);
        vehicle.setType(type);
        vehicle.setYear(year);
    }
}
