<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-My Kit(user)</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>

<c:choose>
        <c:when test="${items==null || items.isEmpty() }">
            <p>No Items Found</p>
        </c:when>
        <c:otherwise>
            <table border="1" cellspacing="5px" cellpadding="5px">
                <tr>
                    <th>ID</th>
                    <th>Kit ID</th>
                    <th>Product</th>
                    <th>Quantity</th>
                    <th>Price</th>
                </tr>
                <c:forEach items="${items}" var="item">
                    <tr>
                    <td>${item.id}</td>
                    <td>${item.kitid }</td>
                    <td>${item.product}</td>
                    <td>${item.quantity }</td>
                    <td>${item.amount}</td>
                    <td>
                        
                        <a href="deleteitem?id=${item.id }">Delete</a> 
                        
                    </td>
                </tr>                
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>

<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>