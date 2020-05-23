/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FloodDetection.bean;

/**
 *
 * @author sujan boudel
 */
public class UserBean {

    private int id;
    private String username;
    private String password;
    private String email;
    private String phone;
  

    public UserBean( String username, String email, String phone, String password) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;

    }

    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
 

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
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
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

}
