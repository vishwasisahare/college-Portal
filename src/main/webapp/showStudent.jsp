<%-- 
    Document   : showStudent
    Created on : 16-Mar-2022, 10:28:48 PM
    Author     : ayush
--%>

<%@page import="com.qt.collegeportal.model.Studentmodel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.qt.collegeportal.contrller.studentcontroller"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css" rel="stylesheet">
        <link href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap4.min.css" rel="stylesheet">
    </head>
    <body>
        
        <!<!-- top navigation include -->
     
        <!<!-- page content start -->
        
        <h1>Show Student<span class="text-success m1-5">${param.msg}</span> </h1>
        
        <table id="example" class="table table-striped table-bordered" style="width:100%">
        <thead>
            <tr>
                <th>sr no</th>
                <th>name</th>
                <th>phone</th>
                <th>email</th>
                <th>degree</th>
                <th>semester</th>
                <th>college</th>
                <th>address</th>
                <th>state</th>
                <th>city</th>
                <th>date</th>
                <th>action</th>
                
            </tr>
        </thead>
        <tbody>
                <%  
                    
                 studentcontroller sc = new studentcontroller();
                    ArrayList<Studentmodel> student = sc.selectAll();
                
                int srno = 1;
                for(Studentmodel sm : student)
                {
                %>
       
     
        
            <tr>
                <td><%= srno %></td>
                <td><%= sm.getName() %></td>
                <td><%= sm.getPhone()%></td>
                <td><%= sm.getEmail()%></td>
                <td><%= sm.getDegree() %></td>
                <td><%= sm.getSemester() %></td>
                <td><%= sm.getCollege() %></td>
                <td><%= sm.getAddress() %></td>
                <td><%= sm.getState() %></td>
                <td><%= sm.getCity() %></td>
                <td><%= sm.getCreatedAt() %></td>
                
                <td>
                    <div class="btn-group">
                        <a href="viewstudent.jsp?id=<%= sm.getId() %>" class="btn btn-primary">view</a>
                        <a href="udateStudent.jsp?id=<%= sm.getId()%>" class="btn btn-primary">update</a>
                        <a href="studentcontroller?id=<%= sm.getId()%>&action=delete" class="btn btn-primary">delete</a>
                        
                    </div>
                </td>
            </tr>
            <%
                srno++;
                
                }  %>
    
        </tbody>
        </table>
                
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.11.5/js/dataTables.bootstrap4.min.js"></script>
        <script>
            $(document).ready(function() {
    $('#example').DataTable();
} );
            <script>

                
          </body>
</html>
