/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import sample.dto.I_List;
import sample.dto.Vehicle;
import sample.dto.filemanager.FileManager;
import sample.dto.filemanager.IFileManager;
import sample.utils.DataValidation;
import sample.utils.Utils;

/**
 *
 * @author vopha
 */
public class VehicleList extends ArrayList<Vehicle> implements I_List {

    IFileManager vFileManager;

    public VehicleList() {
        try {
            vFileManager = new FileManager("vehicle.txt");
            loadDataFromFile(this);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    // Read data
    public void loadDataFromFile(List<Vehicle> listVehicle) throws Exception {
        for (String raw : vFileManager.readDataFromFile()) {
            listVehicle.add(convertStringToVehicle(raw));
        }
    }

    public Vehicle convertStringToVehicle(String rawString) {
        String id, name, color, brand, type;
        double price;
        int year;
        List<String> raw = Arrays.asList(rawString.split(","));

        id = raw.get(0).trim();
        name = raw.get(1).trim();
        color = raw.get(2).trim();
        price = Double.parseDouble(raw.get(3).trim());
        brand = raw.get(4).trim();
        type = raw.get(5).trim();
        year = Integer.parseInt(raw.get(6).trim());

        return new Vehicle(id, name, color, price, brand, type, year);
    }

    @Override
    public void saveToFile() {
        try {
            List<String> rawList = new ArrayList<>();

            for (Vehicle vehicle : this) {
                String line = vehicle.toString() + "\n";
                rawList.add(line);
            }
            vFileManager.commitFile(rawList);
            System.out.println("Saved!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void addNewVehicle() {
        try {
            this.add(Utils.getNewVehicle(this));

            System.out.println("Create vehicle success!");
            String isCont = Utils.getString("Do you want add new user account?(Y/N): ");

            if (isCont.equalsIgnoreCase("y")) {
                addNewVehicle();
            }
        } catch (Exception e) {
            System.out.println("Create vehicle fail!");
        }
    }

    @Override
    public void checkToExistVehicle() {
        String id = Utils.getString("Enter vehicle's id: ");
        List<Vehicle> listVehicleInFile = new ArrayList<>();
        try {
            loadDataFromFile(listVehicleInFile);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        if (DataValidation.checkDuplicate(id, listVehicleInFile)) {
            System.out.println("Exist Vehicle");
        } else {
            System.out.println("No Vehicle Found!");
        }
    }

    @Override
    public void remove() {
        String id = Utils.getString("Enter id: ");
        Vehicle vehicle = Utils.getVehicleById(id, this);

        if (vehicle == null) {
            System.out.println("Vehicle does not exist!");
            return;
        }

        try {
            String confirm = Utils.getString("Confirm dalete? [Y/N]:");

            if (confirm.equalsIgnoreCase("y")) {
                this.remove(vehicle);
            }
            
            System.out.println("Delete success!");
        } catch (Exception e) {
            System.out.println("Delete fail!");
        }

    }

    @Override
    public void update() {
        String id = Utils.getString("Enter id: ");
        Vehicle vehicle = Utils.getVehicleById(id, this);

        if (vehicle == null) {
            System.out.println("Vehicle does not exist!");
            return;
        }

        try {
            Utils.getInfoForUpdate(vehicle);
            System.out.println("Update success!");
        } catch (Exception e) {
            System.out.println("Update fail!");
        }

    }

    @Override
    public void searchVehicle() {
        System.out.println("1.Search by name");
        System.out.println("2.Search by id");

        int choice = Utils.getInt("Select: ", 1, 2);

        switch (choice) {
            case 1:
                seachByName();
                break;
            case 2:
                seachById();
                break;
        }
    }

    public void seachByName() {
        String name = Utils.getString("Enter name: ");
        List<Vehicle> listVehicle = Utils.getVehicleByContainName(name, this);

        if (listVehicle.isEmpty()) {
            System.out.println("Vehicle does not exist!");
            return;
        }

        sortDescendingByPrice(listVehicle);
        for (Vehicle vehicle : listVehicle) {
            System.out.println(vehicle);
        }
    }

    public void seachById() {
        String id = Utils.getString("Enter id: ");
        Vehicle vehicle = Utils.getVehicleById(id, this);

        if (vehicle == null) {
            System.out.println("Vehicle does not exist!");
            return;
        }

        System.out.println(vehicle);
    }

    @Override
    public void sortDescendingByPrice(List<Vehicle> listVehicle) {
        listVehicle.sort((Vehicle v1, Vehicle v2) -> Double.compare(v2.getPrice(), v1.getPrice()));
    }

    @Override
    public void printVehicleList() {
        System.out.println("1.Print all");
        System.out.println("2.Print all(descending by price_vehicle)");

        int choice = Utils.getInt("Select: ", 1, 2);

        switch (choice) {
            case 1:
                printAll();
                break;
            case 2:
                printAllDescendingByPriceVehicle();
                break;
        }
    }

    public void printAll() {
        if (this.isEmpty()) {
            System.out.println("List empty!");
        } else {
            this.forEach((vehicle) -> {
                System.out.println(vehicle);
            });
        }
    }

    public void printAllDescendingByPriceVehicle() {
        if (this.isEmpty()) {
            System.out.println("List empty!");
        } else {
            List<Vehicle> listVehicle = new ArrayList<>();

            this.forEach((vehicle) -> {
                listVehicle.add(vehicle);
            });

            sortDescendingByPrice(listVehicle);

            listVehicle.forEach((vehicle) -> {
                System.out.println(vehicle);
            });
        }
    }
    
    @Override
    public void printMidVehicle() {
        int index = (this.size() - 1) / 2;
        Vehicle vehicle = this.get(index);
        
        System.out.println(vehicle);
    }

}
