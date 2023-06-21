/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.friendtracking;

import static com.mycompany.friendtracking.DataBase.FriendRequestSettings;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author sozcu
 */
public class FriendRequest extends ConnectionClass {

    User temp;

    public FriendRequest() {

    }

    public FriendRequest(User temp) {
        this.temp = temp;

    }

    @Override
    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }
    static ArrayList<User> friends = new ArrayList();

    public void SendRequest(String username) {
        Main frame = new Main(temp);

        boolean userExists = false;
        String url = "jdbc:derby://localhost:1527/sample";

        try {
            java.sql.Connection c = DriverManager.getConnection(url, "app", "app");
            String query = "SELECT * FROM USERS WHERE Username = ?";
            PreparedStatement statement = c.prepareStatement(query);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                User receiverUser = new User();
                receiverUser.setUsername(username);
                FriendRequest request = new FriendRequest();

                request.setReceiver(receiverUser);
                request.setSender(Enterance.temp);

                if (!User.requests.contains(request)) {
                    User.requests.add(request);
                    userExists = true;
                } else {
                    JOptionPane.showMessageDialog(frame, "The request already sended!", "Send Request", JOptionPane.INFORMATION_MESSAGE);

                }
            }

            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (userExists) {
            DataBase.addToFriendRequestTable();
            JOptionPane.showMessageDialog(frame, "The request has been sent!", "Send Request", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame, "The request hasn't been sent!", "Send Request", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    void deleteRequest(String username) {

        for (FriendRequest request : User.requests) {
            if (request.getSender().getUsername().equals(temp.getUsername()) && request.getReceiver().getUsername().equals(username)) {
                User.requests.remove(request);
            }
        }

    }

    /**
     * @return the sender
     */
    public User getSender() {
        return sender;
    }

    /**
     * @param sender the sender to set
     */
    public void setSender(User sender) {
        this.sender = sender;
    }

    /**
     * @return the receiver
     */
    public User getReceiver() {
        return receiver;
    }
}
