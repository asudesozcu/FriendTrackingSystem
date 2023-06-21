/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.friendtracking;

import java.util.ArrayList;

/**
 *
 * @author sozcu
 */
public class User {
User temp;

     static ArrayList<FriendRequest> requests = new ArrayList<>();

    private String username;
    private String password;
    private int age;
    private String gender;
    private personalAccount personalAccount;
    private String Accounttype;

    private BusinessAccount businessAccount;
    
    public User(String username, String password, int age) {
        this.username = username;
        this.password = password;
        this.age = age;

    }

    public void setAccounttype(String Accounttype) {
        this.Accounttype = Accounttype;
    }

    public String getAccounttype() {
        return Accounttype;
    }

    User() {
        
    }

    public User(User temp) {
        this.temp = temp;
      
    }

  

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    
    public personalAccount getPersonalAccount() {
        return personalAccount;
    }

    
    public BusinessAccount getBusinessAccount() {
        return businessAccount;
    }

    /**
     * @return the requests
     */
    /**
     * @param personalAccount the personalAccount to set
     */
    public void setPersonalAccount(personalAccount personalAccount) {
        this.personalAccount = personalAccount;
    }

    /**
     * @param businessAccount the businessAccount to set
     */
    public void setBusinessAccount(BusinessAccount businessAccount) {
        this.businessAccount = businessAccount;
    }

    

}
