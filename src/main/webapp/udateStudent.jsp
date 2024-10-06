

<%@page import="com.qt.collegeportal.model.Studentmodel"%>
<%@page import="com.qt.collegeportal.contrller.studentcontroller"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>update student</title>
    </head>
    <body>
       
      
             <h1>update student</h1>
             
             <%
               studentcontroller sc = new studentcontroller();
               int id =Integer.parseInt(request.getParameter("id"));
             Studentmodel sm = sc.selectById(id);
             
             
             %>
             <form action="studentcontroller" method="post">
                 <input type="hidden" name="action" value="update">
                 <input type="hidden" name="id" value="<%= sm.getId()%>">
           student name: <input type="text" name="name"  value="<%= sm.getName()%>"> <br>
           student email :  <input type="Email" name="email"  value="<%= sm.getEmail()%>">  <br>
           student phone  : <input type="number" name="phone"  value="<%= sm.getPhone()%>"> <br>          
          
 <br>
         Degree:   <select name="degree">
             <option value="<%= sm.getDegree()%>"> <%= sm.getDegree()%></option>
                <option value="MBA">MBA</option>
                <option value="BE">BE</option> 
                <option value="Mastres">Masters</option>
                <option value="BCOM">BCOM</option>
            </select><br>
            
           Semester :  <select name="semester">
                <option value="<%= sm.getSemester()%>"> <%= sm.getSemester()%></option>
                 <option value="1st">1st</option>
                  <option value="2nd">2nd</option> 
                    <option value="3rd">3rd</option>
                      <option value="4th">4th</option>
                        <option value="5th">5th</option>
                          <option value="6th">6th</option>
             </select><br>
           College :  <input type="text" name="college" value="<%= sm.getCollege()%>"> <br>
           Address  <input type="Address" name="address" value="<%= sm.getAddress()%>"> <br>
            City  <select name="city">
                 <option value="<%= sm.getCity()%>"> <%= sm.getCity()%></option>
                <option value="Nagpur">Nagpur</option>
                  <option value="pune">Pune</option> 
                  <option value="mumbai">Mumbai</option>
                  <option value="haidrabaad">Haidrabaad</option>
            </select><br>
             State :<select name="state">
                  <option value="<%= sm.getState()%>"> <%= sm.getState()%></option>
                 <option value="maharashtra">maharshtra</option>
                 <option value="up">UP</option> 
                 <option value="mp">MP</option>
                 <option value="goa">goa</option>
                 <option value="gujrat">Gujrat</option>
                 <option value="assam">Assam</option>
            </select><br>
            
            <input type="submit" value="save">
            <input type="reset" value="clear">
        </form>
    </body>
</html>
