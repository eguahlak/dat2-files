<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Hello World!</h1>
    <hr/>
    <form action="PictureSaveServlet" method="POST" enctype="multipart/form-data">
      <input type="file" name="file" /><button>OK</button>
    </form>
  </body>
</html>
