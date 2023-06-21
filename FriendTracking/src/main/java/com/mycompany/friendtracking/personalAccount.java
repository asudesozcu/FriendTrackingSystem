package com.mycompany.friendtracking;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author sozcu
 */
public class personalAccount extends User {

    private String hobbies;

    public personalAccount(String username, String password, int age) {
        super(username, password, age);
        
    }

    public personalAccount(String hobbies, String username, String password, int age) {
       
        super( username, password,age);
       this.hobbies=hobbies;
    }

    public void viewProfile() {
        getUsername();
        getAge();
        getGender();
        getHobbies();
    }

    
    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }
}
