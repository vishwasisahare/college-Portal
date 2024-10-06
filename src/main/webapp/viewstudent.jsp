<%-- 
    Document   : viewstudent
    Created on : 21-Mar-2022, 5:50:31 PM
    Author     : ayush
--%>

<%@page import="com.qt.collegeportal.model.Studentmodel"%>
<%@page import="com.qt.collegeportal.contrller.studentcontroller"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>view Page</title>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css" rel="stylesheet">
    </head>
    <body>
        <h1>student details</h1>
        <a href="showstudent.jsp" class="btn btn-primary">back</a>
        <%
          studentcontroller sc = new studentcontroller();
          int id = Integer.parseInt(request.getParameter("id"));
          Studentmodel sm = sc.selectById(id);
        
        %>
        
        <table class="table table-striped table-hover">
            <tr>
                <th>Name</th>
                <td><%= sm.getName() %></td>
            </tr>
             <tr>
                <th>Phone</th>
                <td><%= sm.getPhone()%></td>
            </tr>
             <tr>
                <th>Email</th>
                <td><%= sm.getEmail()%></td>
            </tr>
             <tr>
                <th>Degree</th>
                <td><%= sm.getDegree()%></td>
            </tr>
             <tr>
                <th>Semester</th>
                <td><%= sm.getSemester()%></td>
            </tr>
             <tr>
                <th>College</th>
                <td><%= sm.getCollege()%></td>
            </tr>
             <tr>
                <th>Address</th>
                <td><%= sm.getAddress()%></td>
            </tr>
             <tr>
                <th>State</th>
                <td><%= sm.getState()%></td>
            </tr>
             <tr>
                <th>City</th>
                <td><%= sm.getCity()%></td>
            </tr>
             <tr>
                <th>Created</th>
                <td><%= sm.getCreatedAt()%></td>
            </tr>
            
        </table>
    </body>
</html>
