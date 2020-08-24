<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-Home</title>
</head>
<body>
<div>
<jsp:include page="header.jsp"/>
<hr/>
<div>
	<a href="user?action=newuser"><button>Create Corona Kit</button></a>
</div>
<hr/>

	<h2>Admin Login</h2>
	<form action="admin" method="post">
		<div>
			<div><label for="loginid">Login ID</label> </div>
			<div><input type="text" id="loginid" name="loginid" required> </div>
		</div>
		<div>
			<div><label for="password">Password</label> </div>
			<div><input type="password" id="password" name="password" required> </div>
		</div>
		<div>
			<div><input type="submit" value="Login"> </div>
		</div>
	</form>
</div>
	
	<jsp:include page="footer.jsp"/>
</body>
</html>