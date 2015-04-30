<%-- 
    Document   : newjsp
    Created on : Apr 28, 2015, 3:22:04 PM
    Author     : anders
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/navigation" prefix="nav" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Hello World!</h1>
    <nav:target bean="dto.PersonDetail" name="person" />
    <hr/>
    <form method="POST">
      Name: <input name="name" value="${person.name}" /><br/>
      Email: <input name="email" value="${person.email}" /><br/>
      <button name="target" value="Servlet">Go</button>
    </form>
  </body>
</html>
