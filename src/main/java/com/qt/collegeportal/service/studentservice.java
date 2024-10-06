
package com.qt.collegeportal.service;

import com.qt.collegeportal.dao.StudentDao;
import com.qt.collegeportal.model.Studentmodel;
import java.sql.SQLException;
import java.util.ArrayList;



public class studentservice  {
    
    StudentDao sd = new StudentDao();

    public String insertStudent(Studentmodel sm) throws SQLException {

        return sd.insertStudent(sm);
    }

    public ArrayList<Studentmodel> selectAll() {
       
        return sd.selectAll();
    }

    public Studentmodel selectById(int id) throws SQLException {
        return sd.selectById(id);
    }

   

    public int login(String phone, String password) throws SQLException {
       return sd.login(phone,password);
    }

    public String updateStudent(Studentmodel sm) throws SQLException {
        return sd.updateStudent(sm);
    }

    public String deleteStudent(int id) throws SQLException {
       
        return sd.deleteStudent(id);
    }

    
    
    }
            
   

