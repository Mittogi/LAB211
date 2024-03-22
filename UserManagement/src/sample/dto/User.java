package sample.dto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hoa Doan
 */
public class User {
    // change properties to private.
    // create getter, setter, 
    // Create constructor have parameters( need remove init value of properties
    // override toString
    
    private String userName;
    private String firstName;
    private String lastName;
    private String passWord;
    private String phone;
    private String email;

    public User() {
    }

    public User(String userName, String firstName, String lastName, String passWord, String phone, String email) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passWord = passWord;
        this.phone = phone;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" + "userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName + ", passWord=" + passWord + ", phone=" + phone + ", email=" + email + '}';
    }

    public String rawString() {
        return userName + ", " + firstName + ", " + lastName + ", " + passWord + ", " + phone + ", " + email;
    }
}
