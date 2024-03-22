/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.utils;

import java.util.List;
import java.util.Scanner;
import sample.dto.Author;
import sample.dto.Book;
import sample.dto.IAuthorList;

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
    
//------------------------------------------------------------------------------
    public static Book getNewBook(List<Book> listBook, IAuthorList listAuthor){
        String id, isbn, title, authorId;
        Double price;
        
        do {            
            id = getString("Enter new id: ");
        } while (!DataValidation.checkNewId(id, listBook));
        
        isbn = getString("Enter isbn: ");
        title = getString("Enter title: ");
        price = getDouble("Enter price: ", 0.0, Double.MAX_VALUE);
        
        do {            
            authorId = getString("Enter author id: ");
        } while (!listAuthor.checkExist(authorId));
        
        return new Book(id, isbn, title, price, authorId);
    }
}