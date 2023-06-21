/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.friendtracking;

/**
 *
 * @author sozcu
 */
public class BusinessAccount extends User {

    

    private String companyname;
    private String job;

    public BusinessAccount(String username, String password, int age) {
        super(username, password, age);
        
    }

    public BusinessAccount(String companyname, String job, String username, String password, int age) {
        super(username, password, age);
      this.companyname = companyname;
        this.job = job;
    }

    public void viewProfile(String username) {
        getUsername();
        getCompanyname();
        getJob();

    }

    public void viewProfile(User user) {
        getUsername();
        getCompanyname();
        getJob();

    }

    /**
     * @return the companyname
     */
    public String getCompanyname() {
        return companyname;
    }

    /**
     * @return the job
     */
    public String getJob() {
        return job;
    }

    /**
     * @param companyname the companyname to set
     */
    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    /**
     * @param job the job to set
     */
     public void setJob(String job) {
        this.job = job;
    }

}
