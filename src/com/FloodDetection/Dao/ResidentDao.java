/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FloodDetection.Dao;

import com.FloodDetection.Util.DbConnection;
import com.FloodDetection.bean.ResidentBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;

/**
 *
 * @author sujan boudel
 */
public class ResidentDao {

    public void addResident(ResidentBean ub) {

        Connection con = DbConnection.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement("insert into residents (FNAME,LNAME,PHONE,SUBURB) values (?,?,?,?)");
            ps.setString(1, ub.getFirstName());
            ps.setString(2, ub.getLastName());
            ps.setString(3, ub.getPhone());
            ps.setString(4, ub.getSuburb());
            ps.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//     public ArrayList<residentBean> getAllRecords() {
    public ArrayList<ResidentBean> getAllRecords() {
        ResultSet rs = null;
        Connection con = DbConnection.getConnection();
        ArrayList<ResidentBean> list = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("select * from residents");
            rs = ps.executeQuery();
            while (rs.next()) {
                ResidentBean rb = new ResidentBean();
                rb.setId(rs.getInt(1));
                rb.setFirstName(rs.getString(2));
                rb.setLastName(rs.getString(3));
                rb.setPhone(rs.getString(4));
                rb.setSuburb(rs.getString(5));
                list.add(rb);
            }
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public void updateResident(ResidentBean rb) {
        Connection con = DbConnection.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement("update residents set fname=?, lname=? ,phone=?, suburb=? where id =?");
            ps.setString(1, rb.getFirstName());
            ps.setString(2, rb.getLastName());
            ps.setString(3, rb.getPhone());
            ps.setString(4, rb.getSuburb());
            ps.setInt(5, rb.getId());
            ps.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResidentBean getResident(String id) {
        ResultSet rs;
        Connection con = DbConnection.getConnection();
        ResidentBean rb = new ResidentBean();
        try {
            PreparedStatement ps = con.prepareStatement("select * from residents where id =?");
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                rb.setId(rs.getInt(1));
                rb.setFirstName(rs.getString(2));
                rb.setLastName(rs.getString(3));
                rb.setPhone(rs.getString(4));
                rb.setSuburb(rs.getString(5));
            }
            con.close();
            return rb;
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int deleteResident(String id) {
        int flag = 0;
        Connection con = DbConnection.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement("delete from residents where id =?");
            ps.setString(1, id);
            flag = ps.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public ArrayList<ResidentBean> searchResident(String searchText) {
        ResultSet rs;
        Connection con = DbConnection.getConnection();
        ArrayList<ResidentBean> al = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("select * from residents where phone like ?");
            ps.setString(1, "%" + searchText + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                ResidentBean rb = new ResidentBean();
                rb.setId(rs.getInt(1));
                rb.setFirstName(rs.getString(2));
                rb.setLastName(rs.getString(3));
                rb.setPhone(rs.getString(4));
                rb.setSuburb(rs.getString(5));
                al.add(rb);
            }
            con.close();
            return al;
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
