/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.utils;

import java.util.List;
import sample.dto.User;

/**
 *
 * @author vopha
 */
public class DataValidation {

    public static boolean isDuplicate(String string, List<User> listUser) {
        for (User user : listUser) {
            if (user.getUserName().equals(string)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isMatches(String string, String pattern) {
        return string.matches(pattern);
    }
//------------------------------------------------------------------------------

    public static boolean isUserNameValid(String userName, List<User> listUser) {
        if (userName.length() < 5) {
            return false;
        }

        if (userName.contains(" ")) {
            return false;
        }

        if (isDuplicate(userName, listUser)) {
            return false;
        }

        return true;
    }

    public static boolean isPassWordValid(String passWord) {
        if (passWord.length() < 6) {
            return false;
        }

        if (passWord.contains(" ")) {
            return false;
        }

        return true;
    }

    public static boolean isPhoneValid(String phone) {
        if (!isMatches(phone, "\\d{10}")) {
            return false;
        }

        return true;
    }

    public static boolean isEmailValid(String email) {
        if (isMatches(email, "^[a-zA-Z0-9_+&*-]+"
                           + "(\\.[a-zA-Z0-9_+&*-]+)*"
                           + "@([a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
            return true;
        }
        
        return false;
    }

    public static boolean isLogInValid(String userName, String passWord, List<User> userList) {
        for (User user : userList) {
            if (userName.equals(user.getUserName())) {
                if (passWord.equals(user.getPassWord())) {
                    return true;
                }
            }
        }

        return false;
    }
}
