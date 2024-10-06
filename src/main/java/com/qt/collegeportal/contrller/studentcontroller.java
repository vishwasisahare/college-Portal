
package com.qt.collegeportal.contrller;

import com.qt.collegeportal.model.Studentmodel;
import com.qt.collegeportal.service.studentservice;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "studentcontroller", urlPatterns = {"/studentcontroller"})
public class studentcontroller extends HttpServlet {
    
    Studentmodel sm = new Studentmodel();
    studentservice ss = new studentservice();
    String message = null;

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
       String action = request.getParameter("action");
            switch(action){
                case "insert":
                    //insert code
                    insertstudent(request, response);
                     break;
                   
                case "update":
                    //update code
                    updateStudent(request, response);
                    break;
                    
                case "delete":
                    //Delete code
                    deleteStudent(request,response);
                    break;
                    
                  case "login":
                    //login code
                      login(request, response);
                    break;   
    }
    }

  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(studentcontroller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  
     
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(studentcontroller.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void insertstudent(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        sm.setName(request.getParameter("name"));    
        sm.setEmail(request.getParameter("email"));
        sm.setPhone(request.getParameter("phone"));
        sm.setDegree(request.getParameter("degree"));
        sm.setSemester(request.getParameter("semester"));
        sm.setCollege(request.getParameter("college"));
        sm.setAddress(request.getParameter("address"));
        sm.setState(request.getParameter("state"));
        sm.setCity(request.getParameter("city"));
        
        message = ss.insertStudent(sm);
        response.sendRedirect("addstudent.jsp?msg="+message);
           }
    
     
    public ArrayList<Studentmodel> selectAll(){
        
        return ss.selectAll();
    }
    public Studentmodel selectById(int id) throws SQLException{
        return ss.selectById(id);
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
       String phone = request.getParameter("phone");
       String password = request.getParameter("password");
       int status = ss.login(phone,password);
       if(status == 1){
           response.sendRedirect("index.jsp?msg=login success");
       }else{
           response.sendRedirect("login.jsp?msg= incorrect login details");
       }
       
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        
        sm.setId(Integer.parseInt(request.getParameter("id")));
        sm.setName(request.getParameter("name"));
        sm.setEmail(request.getParameter("email"));
        sm.setPhone(request.getParameter("phone"));
        sm.setDegree(request.getParameter("degree"));
        sm.setSemester(request.getParameter("semester"));
        sm.setCollege(request.getParameter("college"));
        sm.setAddress(request.getParameter("address"));
        sm.setState(request.getParameter("state"));
        sm.setCity(request.getParameter("city"));
        message =ss.updateStudent(sm);
        
        response.sendRedirect("showStudent.jsp?msg="+message);
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
         
        int id = Integer.parseInt(request.getParameter("id"));
        
        message = ss.deleteStudent(id);
        
        response.sendRedirect("showStudent.jsp?msg="+message);
    }
}
