/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.friendtracking;

import java.util.ArrayList;

/**
 *
 * @author sozcu
 */
public class Post {

    User temp;

    public Post(User temp) {
        this.temp = temp;

    }

    public Post() {
    }

    private String content;
    private int likes;
    private User sender;
    

    static ArrayList<Post> posts = new ArrayList();

    public Post(String content, User sender) {
        this.content = content;
        this.sender = sender;
    }

    public void addLike(User sender) {
        this.setLikes(this.getLikes() + getLikes());

    }

    public void removeLikes(User sender) {
        this.setLikes(this.getLikes() - getLikes());
    }

    public int showLikes() {
        return getLikes();
    }

    /**
     * @return the sender
     */
    public User getSender() {
        return sender;
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

    /**
     * @return the likes
     */
    public int getLikes() {
        return likes;
    }

    /**
     * @param likes the likes to set
     */
    public void setLikes(int likes) {
        this.likes = likes;
    }

    /**
     * @param sender the sender to set
     */
    public void setSender(User sender) {
        this.sender = sender;
    }
    @Override
    public String toString() {
        return sender.getUsername() + "|" + content + "|" + likes; 
    }
    /**
     * @return the comments
     */
}
