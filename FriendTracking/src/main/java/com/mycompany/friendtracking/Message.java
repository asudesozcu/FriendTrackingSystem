/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.friendtracking;

import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author sozcu
 */
public class Message extends ConnectionClass {

    User temp;
    Message message;
    private String context;
    static ArrayList< Message> messages = new ArrayList<>();

    public Message() {
    }

    public Message(User temp) {
        this.temp = temp;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Message getMessage() {
        return message;
    }

    public Message(User receiver, User sender, String context) {
        this.context = context;
        super.receiver = receiver;
        super.sender = sender;
    }

    public void getConversation(String context, User receiver) {
        Message message1 = new Message();
        message1.setReceiver(receiver);
        message1.setSender(temp);
        message1.setContext(context);
        messages.add(message1);
    }

    /**
     * @return the context
     */
    public String getContext() {
        return context;
    }

    /**
     * @param context the context to set
     */
    public void setContext(String context) {
        this.context = context;
    }

}
