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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import sample.dto.I_List;
import sample.dto.User;
import sample.dto.filemanager.FileManager;
import sample.dto.filemanager.IFileManager;
import sample.utils.DataValidation;
import sample.utils.Utils;

public class UsertList extends ArrayList<User> implements I_List {

    private IFileManager fileManager;

    public UsertList() throws Exception {
        try {
            fileManager = new FileManager("user.dat");
            loadDataFromFile(this);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void loadDataFromFile(List<User> listUser) throws Exception {
        for (String raw : fileManager.readDataFromFile()) {
            listUser.add(convertStringToUser(raw));
        }
    }

    public User convertStringToUser(String raw) {
        String userName, firstName, lastName, passWord, phone, email;

        List<String> listRaw = Arrays.asList(raw.split(", "));

        userName = listRaw.get(0);
        firstName = listRaw.get(1);
        lastName = listRaw.get(2);
        passWord = listRaw.get(3);
        phone = listRaw.get(4);
        email = listRaw.get(5);

        return new User(userName, firstName, lastName, passWord, phone, email);

    }

    @Override
    public void saveFile() {
        try {
            List<String> listRawString = new ArrayList<>();

            for (User user : this) {
                String line = user.rawString();
                listRawString.add(line);
            }

            fileManager.commitFile(listRawString);
            System.out.println("Saved!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

//    @Override
//    public int find(String code) {
//        
//    }
    @Override
    public void addUser() {
        this.add(Utils.getNewUser(this));

        System.out.println("Create user account success!");
        String isCont = Utils.getString("Do you want add new user account?(Y/N): ");

        if (isCont.equalsIgnoreCase("y")) {
            addUser();
        }
    }

    @Override
    public void findUserInFile() {
        List<User> listUserInFile = new ArrayList<>();
        try {
            loadDataFromFile(listUserInFile);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());;
        }

        String userName = Utils.getString("Enter user name: ");

        for (User user : listUserInFile) {
            if (user.getUserName().equals(userName)) {
                System.out.println("Exist User!");
                return;
            }
        }
        System.out.println("No User Found!");
    }

    @Override
    public void searchUserInformationByName() {
        String searchString = Utils.getString("Enter search string: ", "");
        List<User> listUserSearched = new ArrayList<>();
        
        for (User user : this) {
            if (user.getFirstName().contains(searchString) || user.getLastName().contains(searchString)) {
                listUserSearched.add(user);
            }
        }
        
        if (listUserSearched.isEmpty()) {
            System.out.println("Have no any user!");
        } else {
            sortByFirstName(listUserSearched);
            listUserSearched.forEach((user) -> {
                System.out.println(user);
            });
        }
    }

    @Override
    public void remove() {
        User user = logIn();

        if (user == null) {
            return;
        }
        try {
            for (User userEmp : this) {
                if (userEmp == user) {
                    this.remove(user);
                    System.out.println("Delete success!");
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Delete fail!");
        }
    }

    @Override
    public void update() {
        User user = logIn();

        if (user == null) {
            return;
        }

        try {
            Utils.getInfoUserForUpdate(user);
            System.out.println("Update success!");
        } catch (Exception e) {
            System.out.println("Update fail!");
        }
    }

    @Override
    public void sortByFirstName(List<User> listUser) {
        listUser.sort((User o1, User o2) -> o1.getFirstName().compareTo(o2.getFirstName()));
    }

    @Override
    public void printAllListFromFile() {
        List<User> listUserInFile = new ArrayList<>();
        try {
            loadDataFromFile(listUserInFile);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        sortByFirstName(listUserInFile);
        
        if (listUserInFile.isEmpty()) {
            System.out.println("List is empty!");
        } else {
            listUserInFile.forEach((user) -> {
                System.out.println(user);
            });
        }
    }
    
    @Override
    public void getFirstUser() {
        User firstUser = this.get(0);
        System.out.println("Infor of first user:");
        System.out.println(firstUser);
    }

//------------------------------------------------------------------------------
    private User logIn() {
        String userName, passWord;
        User user = null;

        System.out.println("Log in");
        userName = Utils.getString("User name: ");
        passWord = Utils.getString("Pass word: ");

        if (!DataValidation.isLogInValid(userName, passWord, this)) {
            System.out.println("Account is invalid!");
            return user;
        } else {
            for (User userEmp : this) {
                if (userName.equals(userEmp.getUserName())) {
                    user = userEmp;
                    break;
                }
            }
        }

        return user;
    }
}
