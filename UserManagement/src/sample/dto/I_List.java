package sample.dto;

import java.util.List;

/* Interface for a group of objects
 */

/**
 *
 * @author Hoa Doan
 */
public interface I_List {
  // Find the position of element which has code equal parameter coe
//  int find(String code);
  // add new element( input from scanner) to I_List
  void addUser(); 
  void findUserInFile();
  void searchUserInformationByName();
  // Input the code wanna remove
  void remove();
  // input the code want to update, after that update other information--> use set method
  void update();
  // sortByFirstName list use Collections.sortByFirstName(this, new Comparator<Clock>()..., sortByFirstName based price or make
  void sortByFirstName(List<User> listUser);
  // show detail of each element of List
  void printAllListFromFile();
  // save data to file
  void saveFile();
  //show information of first user in list
  void getFirstUser();
}
