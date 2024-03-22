/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.utils;

import java.util.List;
import java.util.Scanner;
import sample.dto.User;

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
            result = sc.nextLine().trim();
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
        String tmp = sc.nextLine().trim();
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
                number = Integer.parseInt(sc.nextLine());
                check = false;
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
                String tmp = sc.nextLine();
                if (tmp.isEmpty()) {
                    check = false;
                } else {
                    number = Integer.parseInt(tmp);
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

    //-----------------------------------------------------------------------------
    public static User getNewUser(List<User> listUser) {
        String userName, firstName, lastName, passWord, phone, email;
        System.out.println("Create new user account");

        do {
            userName = getString("Enter user name: ");

            if (!DataValidation.isUserNameValid(userName, listUser)) {
                System.out.println("User name is invalid!");
            }
        } while (!DataValidation.isUserNameValid(userName, listUser));

        do {
            firstName = getString("Enter first name: ");
        } while (firstName.isEmpty());

        do {
            lastName = getString("Enter last name: ");
        } while (lastName.isEmpty());

        do {
            passWord = getString("Enter pass word: ");

            if (!DataValidation.isPassWordValid(passWord)) {
                System.out.println("Pass word is invalid!");
            }
        } while (!DataValidation.isPassWordValid(passWord));

        do {
            String comfirmPassWord = getString("Enter confirm pass word: ");

            if (!comfirmPassWord.equals(passWord)) {
                System.out.println("Comfirm pass word is not match pass word!");
            } else {
                break;
            }
        } while (true);

        do {
            phone = getString("Enter phone: ");

            if (!DataValidation.isPhoneValid(phone)) {
                System.out.println("Phone is invalid!");
            }
        } while (!DataValidation.isPhoneValid(phone));

        do {
            email = getString("Enetr email: ");

            if (!DataValidation.isEmailValid(email)) {
                System.out.println("Email is invalid!");
            }
        } while (!DataValidation.isEmailValid(email));

        User user = new User(userName, firstName, lastName, passWord, phone, email);

        return user;
    }

    public static void getInfoUserForUpdate(User user) {
        String newFirstName, newLastName, newPassWord, newPhone, newEmail;

        newFirstName = getString("Enter new first name: ", user.getFirstName());
        newLastName = getString("Enter new last name: ", user.getLastName());

        do {
            newPassWord = getString("Enter new pass word: ", user.getPassWord());

            if (!DataValidation.isPassWordValid(newPassWord)) {
                System.out.println("New pass word is invalid!");
            }
        } while (!DataValidation.isPassWordValid(newPassWord));

        if (!user.getPassWord().equals(newPassWord)) {
            String confirmNewPassWord;
            
            do {                
                confirmNewPassWord = Utils.getString("Enter confirm new pass word: ");
                if (!confirmNewPassWord.equals(newPassWord)) {
                    System.out.println("Comfirm new pass word is not match new pass word!");
                }
            } while (!confirmNewPassWord.equals(newPassWord));
        }
        
        do {
            newPhone = getString("Enter new phone: ", user.getPhone());

            if (!DataValidation.isPhoneValid(newPhone)) {
                System.out.println("New phone is invalid!");
            }
        } while (!DataValidation.isPhoneValid(newPhone));

        do {
            newEmail = getString("Enter new email: ", user.getEmail());

            if (!DataValidation.isEmailValid(newEmail)) {
                System.out.println("New email is invalid!");
            }
        } while (!DataValidation.isEmailValid(newEmail));

        user.setFirstName(newFirstName);
        user.setLastName(newLastName);
        user.setPassWord(newPassWord);
        user.setPhone(newPhone);
        user.setEmail(newEmail);
    }
}
