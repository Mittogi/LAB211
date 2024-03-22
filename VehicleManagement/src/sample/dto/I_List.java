package sample.dto;

import java.util.List;

/* Interface for a group of objects
 */
/**
 *
 * @author Hoa Doan
 */
public interface I_List {

    void saveToFile();
    // addNewVehicle new element( input from scanner) to I_List

    void addNewVehicle();
    // Find the position of element which has code equal parameter coe

    void checkToExistVehicle();
    // Input the code wanna remove

    void remove();
    // input the code want to update, after that update other information--> use set method

    void update();
    
    void searchVehicle();
    // sortDescendingByPrice list use Collections.sortDescendingByPrice(this, new Comparator<Clock>()..., sortDescendingByPrice based price or make

    void sortDescendingByPrice(List<Vehicle> listVehicle);
    // show detail of each element of List

    void printVehicleList();
    
    void printMidVehicle();

}
