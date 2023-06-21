/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.friendtracking;

/**
 *
 * @author sozcu
 */
public class Comment extends ConnectionClass {

    private String content;

    public Comment(String content, User receiver, User sender) {
        this.content = content;
        
        super.receiver = receiver;
        super.sender = sender;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

}
