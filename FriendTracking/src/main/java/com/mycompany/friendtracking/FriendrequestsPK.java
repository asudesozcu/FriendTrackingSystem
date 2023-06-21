/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.friendtracking;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author sozcu
 */
@Embeddable
public class FriendrequestsPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "SENDERUSERNAME")
    private String senderusername;
    @Basic(optional = false)
    @Column(name = "RECEIVERUSERNAME")
    private String receiverusername;

    public FriendrequestsPK() {
    }

    public FriendrequestsPK(String senderusername, String receiverusername) {
        this.senderusername = senderusername;
        this.receiverusername = receiverusername;
    }

    public String getSenderusername() {
        return senderusername;
    }

    public void setSenderusername(String senderusername) {
        this.senderusername = senderusername;
    }

    public String getReceiverusername() {
        return receiverusername;
    }

    public void setReceiverusername(String receiverusername) {
        this.receiverusername = receiverusername;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (senderusername != null ? senderusername.hashCode() : 0);
        hash += (receiverusername != null ? receiverusername.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FriendrequestsPK)) {
            return false;
        }
        FriendrequestsPK other = (FriendrequestsPK) object;
        if ((this.senderusername == null && other.senderusername != null) || (this.senderusername != null && !this.senderusername.equals(other.senderusername))) {
            return false;
        }
        if ((this.receiverusername == null && other.receiverusername != null) || (this.receiverusername != null && !this.receiverusername.equals(other.receiverusername))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.friendtracking.FriendrequestsPK[ senderusername=" + senderusername + ", receiverusername=" + receiverusername + " ]";
    }
    
}
