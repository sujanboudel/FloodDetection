/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FloodDetection.Dao;

import com.FloodDetection.Util.DbConnection;
import com.FloodDetection.bean.UserBean;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author sujan boudel
 */
public class UserDao {

//    UserBean ub = new UserBean("ram", "pass", "abc@gmail.com", "0426963668");
//    public static void main(String[] args) {
//        UserDao u = new UserDao();
//        u.addUser();
//
////        u.addUser();
//    }
    public boolean verifyUser(UserBean u) {
        Connection con = DbConnection.getConnection();
        try {

//                ("create table users "); 
//             con.createStatement().execute("insert into users (id , firstName)values (1,'sujan')");
//                ResultSet rs=con.createStatement().execute("select from  users");
//                ResultSet rs=(ResultSet) statement.executeQuery("select * from users");
//                PreparedStatement statement = con.prepareStatement("insert into users values (?,?,?,?)");
//
//                statement.setString(1, ub.getUsername());
//                statement.setString(2, ub.getPassword());
//                statement.setString(3, ub.getEmail());
//                statement.setString(4, ub.getPhone());
            PreparedStatement ps = con.prepareStatement("select * from users where username=? and password=?");
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                con.close();
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void addUser(UserBean ub) {

        Connection con = DbConnection.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement("insert into users (USERNAME,PASSWORD,EMAIL,PHONE) values (?,?,?,?)");
            ps.setString(1, ub.getUsername());
            ps.setString(2, ub.getPassword());
            ps.setString(3, ub.getEmail());
            ps.setString(4, ub.getPhone());
            ps.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
