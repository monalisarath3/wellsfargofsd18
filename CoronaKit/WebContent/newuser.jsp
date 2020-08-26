<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-New User(user)</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>

<form action="showproducts" method="POST">
        <div>
            <label>Name: </label>
            <input type="text" name="pname" required 
              />
        </div>
        <div>
            <label>Email: </label>
            <input type="text" name="pmail" required/>
        </div>
        <div>
            <label>Phone: </label>
            <input type="number" pattern=".{10}" name="pnumber" required />
        </div>
        
        
        <button>Create Kit</button>        
    </form>



<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>