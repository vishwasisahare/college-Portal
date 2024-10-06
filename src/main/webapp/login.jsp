<%-- 
    Document   : login
    Created on : 25-Mar-2022, 5:58:54 PM
    Author     : ayush
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>student login</h1>
    <html>
      
            <form action="studentcontroller" method="post">
                 <input type="hidden" name="action" value="login">
         phone :   <input type="text" name="phone" placeholder="Enter your phone no"><br>
         password :  <input type="password" name="password" placeholder="Enter your password">  <br>
        
        <input type="submit" value="save">
        <input type="reset" value="clear">    
            
        </form>
        <h2>${param.msg}</h2>
        
   
    </body>
     
</html>
