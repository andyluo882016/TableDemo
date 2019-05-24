<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <form action="/addemp" method="post">
      ID: <input type="text" name="id" /><br>
      Name: <input type="text" name="name" /><br>
      Submit: <input type="submit"><br>
    
   </form><br><hr>
   <div>
     <form action="/employees" method="post">
      Name: <input type="text" name="name" /><br>
      Submit: <input type="submit"><br>
    
   </form>
   
   </div>
</body>
</html>