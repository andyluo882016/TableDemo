<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<jsp:include page="show.jsp"></jsp:include>
<title>Welcome :: Home</title>
</head>
<body>
<jsp:include page="show.jsp"></jsp:include>
<div class="container">
<h1>Welcome to Spring!</h1><hr />
<P>There are ${serverTime}(${totalTasks}) open tasks.</P>
</div>
</body>
</html>