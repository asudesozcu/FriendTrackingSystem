/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.friendtracking;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author sozcu
 */
@Entity
@Table(name = "BUSINNESACCOUNTS")
@NamedQueries({
@NamedQuery(name = "Businnesaccounts.findAll", query = "SELECT b FROM Businnesaccounts b"),
@NamedQuery(name = "Businnesaccounts.findByUsername", query = "SELECT b FROM Businnesaccounts b WHERE b.username = :username"),
@NamedQuery(name = "Businnesaccounts.findByCompanyname", query = "SELECT b FROM Businnesaccounts b WHERE b.companyname = :companyname"),
@NamedQuery(name = "Businnesaccounts.findByAge", query = "SELECT b FROM Businnesaccounts b WHERE b.age = :age"),
@NamedQuery(name = "Businnesaccounts.findByJob", query = "SELECT b FROM Businnesaccounts b WHERE b.job = :job")})
public class Businnesaccounts implements Serializable {

    @Column(name = "PASSWORD")
    private String password;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @Column(name = "COMPANYNAME")
    private String companyname;
    @Column(name = "AGE")
    private Integer age;
    @Column(name = "JOB")
    private String job;

    public Businnesaccounts() {
    }

    public Businnesaccounts(String username) {
        this.username = username;
    }

    public Businnesaccounts(String username, String companyname) {
        this.username = username;
        this.companyname = companyname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Businnesaccounts)) {
            return false;
        }
        Businnesaccounts other = (Businnesaccounts) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.friendtracking.Businnesaccounts[ username=" + username + " ]";
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
