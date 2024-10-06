<%-- 
    Document   : addstudent
    Created on : 10-Mar-2022, 7:40:12 PM
    Author     : ayush
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Student</title>
    </head>
    <body>
       
      
             <h1>Student Record</h1>
             <h4 style="color: red"> ${param.msg} </h4>
             <form action="studentcontroller" method="post">
                 <input type="hidden" name="action" value="insert">
            <input type="text" name="name" placeholder="Enter your name"><br>
             <input type="Email" name="email" placeholder="Enter your email">  <br>
             <input type="number" name="phone" placeholder="Enter your phone no"><br>
            <select name="degree">Degree
                <option value="MBA">MBA</option>
                <option value="BE">BE</option> 
                <option value="Mastres">Masters</option>
                <option value="BCOM">BCOM</option>
            </select><br>
            
           Semester :  <select name="semester">
                 <option value="1st">1st</option>
                  <option value="2nd">2nd</option> 
                    <option value="3rd">3rd</option>
                      <option value="4th">4th</option>
                        <option value="5th">5th</option>
                          <option value="6th">6th</option>
             </select><br>
           College :  <input type="text" name="college" placeholder="Enter your college name"><br>
           Address  <input type="Address" name="address" placeholder="Enter your address"><br>
            City  <select name="city">
                <option value="Nagpur">Nagpur</option>
                  <option value="pune">Pune</option> 
                  <option value="mumbai">Mumbai</option>
                  <option value="haidrabaad">Haidrabaad</option>
            </select><br>
             State :<select name="state">
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
