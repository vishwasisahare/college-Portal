/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.collegeportal.dao;

import com.mysql.cj.Messages;
import com.qt.collegeportal.database.Database;
import com.qt.collegeportal.model.Studentmodel;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ayush
 */
public class StudentDao {

    String message = null;
    String sql = null;
    CallableStatement cs = null;

    public String insertStudent(Studentmodel sm) throws SQLException {

        Connection con = Database.connectDb(); //1 step conn create
        try {
            sql = "insert into student (name ,Email ,phone , Degree ,semester ,college ,Address ,state ,city )values (?,?,?,?,?,?,?,?,?)";
            cs = con.prepareCall(sql); //2nd step           
            cs.setString(1, sm.getName()); //set value for each col
            cs.setString(2, sm.getEmail());                
            cs.setString(3, sm.getPhone());
            cs.setString(4, sm.getDegree());  
            cs.setString(5, sm.getSemester());
            cs.setString(6, sm.getCollege());
            cs.setString(7, sm.getAddress());
            cs.setString(8, sm.getState());
            cs.setString(9, sm.getCity());

            int rows = cs.executeUpdate(); //fire query
            if (rows >= 1) {
                message = "Record insert successfully";
            }
        } catch (Exception e) {
            message = "unable to insert bcoz :" + e.getMessage();
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return message;
    }

    public ArrayList<Studentmodel> selectAll() {
        Connection con = Database.connectDb();
        ArrayList<Studentmodel> student = new ArrayList();      
        ResultSet rs = null;

        try {
            sql = "select * from student";
            cs = con.prepareCall(sql);
            rs = cs.executeQuery(); //all record return and store is rs

            while (rs.next()) {
                student.add(
                        new Studentmodel(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("email"),
                                rs.getString("phone"),
                                rs.getString("degree"),
                                rs.getString("semester"),
                                rs.getString("college"),
                                rs.getString("address"),
                                rs.getString("state"),
                                rs.getString("city"),
                                rs.getString("created_at"),
                                rs.getString("modifeid_at"))
                );
            }
        } catch (Exception e) {
            System.out.println("error in SelectAll : " + e.getMessage());
        }finally{
             if(con != null){
                 try {
                     con.close();
                 } catch (SQLException ex) {
                     Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex); 
                     
                 }
             }
        }
        
        return student;
    }

    public Studentmodel selectById(int id) throws SQLException {
        
        Connection con = Database.connectDb();
        Studentmodel student = null;
        ResultSet rs = null;
        try {
            sql = "select * from student where id = "+id;
            cs = con.prepareCall(sql);
            rs = cs.executeQuery();  //all record store and return rs
            
            while (rs.next()){
                       student = new Studentmodel(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("email"),
                                rs.getString("phone"),
                                rs.getString("degree"),
                                rs.getString("semester"),
                                rs.getString("college"),
                                rs.getString("address"),
                                rs.getString("state"),
                                rs.getString("city"),
                                rs.getString("created_at"),
                                rs.getString("modifeid_at")
                       );
            }
            
        } catch (Exception e) {
                 System.out.println("error in select by id :"+e.getMessage());
        }finally{
            if(con != null){
                try {
                    con.close();
                } catch (Exception e) {
                    
                }
            }
        }
            return student;
        }

    public int login(String phone, String password) throws SQLException {
        Connection con = Database.connectDb();
        ResultSet rs = null;
        int status = 0;
        
        try {
            sql = "select * from admin where phone =? AND password?";
            cs = con.prepareCall(sql);
            cs.setString(1, phone);
            cs.setString(2, password);
            rs = cs.executeQuery();
            while(rs.next()){
                status = 1;
            }
            
        } catch (SQLException e) {
            System.out.println("com.qt.collegeportal.dao.StudentDao.login()"+e.getMessage());
        }finally{
            if(con != null){
                con.close();
            }
        }
        return status;
    }

    public String updateStudent(Studentmodel sm) throws SQLException {
       Connection con = Database.connectDb();
        try {
            sql = "update student set name = ?, email = ?, phone = ?, degree = ?, semester = ?,college = ?,address = ?, state = ?,city = ? where id = ?  ";
            cs = con.prepareCall(sql); 
            cs.setString(1, sm.getName());
            cs.setString(2, sm.getEmail());
            cs.setString(3, sm.getPhone());
            cs.setString(4, sm.getDegree());
            cs.setString(5, sm.getSemester());
            cs.setString(6, sm.getCollege());
            cs.setString(7, sm.getAddress());
            cs.setString(8, sm.getState());
            cs.setString(9, sm.getCity());
            cs.setInt(10, sm.getId());
            
            int rows = cs.executeUpdate(); 
            
            if(rows >= 1){
                message = "student update successfull";
            }
        } catch (Exception e) {
            message = "update to update bcoz of :"+e.getMessage();
        }finally{
            if(con != null){
                con.close();
            }
        }
        return message;
    }

    public String deleteStudent(int id) throws SQLException {
        
        Connection con = Database.connectDb();
        try {
           
            sql="delete from student where id = "+id; 

            cs = con.prepareCall(sql); 
            int rows =cs.executeUpdate(); 
            if(rows>=1){ 
                message ="student delete suceesfull"; 
                
             
            }
        } catch (Exception e) { 
                            message ="unable to delete "+e.getMessage(); 

        }finally{ 
            if(con !=null){ 
                con.close();
            }
        }
        return message;
    }
       
}
