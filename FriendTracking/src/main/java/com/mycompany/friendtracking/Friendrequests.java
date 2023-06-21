/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.friendtracking;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author sozcu
 */
@Entity
@Table(name = "FRIENDREQUESTS")
@NamedQueries({
    @NamedQuery(name = "Friendrequests.findAll", query = "SELECT f FROM Friendrequests f"),
    @NamedQuery(name = "Friendrequests.findBySenderusername", query = "SELECT f FROM Friendrequests f WHERE f.friendrequestsPK.senderusername = :senderusername"),
    @NamedQuery(name = "Friendrequests.findByReceiverusername", query = "SELECT f FROM Friendrequests f WHERE f.friendrequestsPK.receiverusername = :receiverusername"),
    @NamedQuery(name = "Friendrequests.findBySendingtime", query = "SELECT f FROM Friendrequests f WHERE f.sendingtime = :sendingtime"),
    @NamedQuery(name = "Friendrequests.findBySenderage", query = "SELECT f FROM Friendrequests f WHERE f.senderage = :senderage")})
public class Friendrequests implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FriendrequestsPK friendrequestsPK;
    @Column(name = "SENDINGTIME")
    @Temporal(TemporalType.TIME)
    private Date sendingtime;
    @Column(name = "SENDERAGE")
    private Integer senderage;

    public Friendrequests() {
    }

    public Friendrequests(FriendrequestsPK friendrequestsPK) {
        this.friendrequestsPK = friendrequestsPK;
    }

    public Friendrequests(String senderusername, String receiverusername) {
        this.friendrequestsPK = new FriendrequestsPK(senderusername, receiverusername);
    }

    public FriendrequestsPK getFriendrequestsPK() {
        return friendrequestsPK;
    }

    public void setFriendrequestsPK(FriendrequestsPK friendrequestsPK) {
        this.friendrequestsPK = friendrequestsPK;
    }

    public Date getSendingtime() {
        return sendingtime;
    }

    public void setSendingtime(Date sendingtime) {
        this.sendingtime = sendingtime;
    }

    public Integer getSenderage() {
        return senderage;
    }

    public void setSenderage(Integer senderage) {
        this.senderage = senderage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (friendrequestsPK != null ? friendrequestsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Friendrequests)) {
            return false;
        }
        Friendrequests other = (Friendrequests) object;
        if ((this.friendrequestsPK == null && other.friendrequestsPK != null) || (this.friendrequestsPK != null && !this.friendrequestsPK.equals(other.friendrequestsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.friendtracking.Friendrequests[ friendrequestsPK=" + friendrequestsPK + " ]";
    }
    
}
