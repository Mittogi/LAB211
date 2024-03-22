/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.utils;

import java.util.List;
import sample.dto.Book;

/**
 *
 * @author vopha
 */
public class DataValidation {

    public static boolean checkDuplicate(String string, List<Book> listBook) {
        for (Book book : listBook) {
            if (book.getId().equals(string)) {
                return true;
            }
        }

        return false;
    }

    public static boolean checkMatches(String string, String pattern) {
        return string.matches(pattern);
    }

//------------------------------------------------------------------------------
    public static boolean checkNewId(String id, List<Book> listBook) {
        if (!checkMatches(id, "\\d{5}")) {
            System.out.println("Id invalid. The correct id is xxxxx with x is digit!");
            return false;
        }

        if (checkDuplicate(id, listBook)) {
            System.out.println("Id is duplicate!");
            return false;
        }

        return true;
    }
}
