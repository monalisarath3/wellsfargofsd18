<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-All Products(user)</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>
<div>
            <label>Kit ID: </label>
            <input type="number"  name="kitid" required 
              />
        </div>
       
 <hr/>
 <c:choose>
        <c:when test="${items==null || items.isEmpty() }">
            <p>No Items Found</p>
        </c:when>
        <c:otherwise>
            <table border="1" cellspacing="5px" cellpadding="5px">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Cost</th>
                    <th>Description</th>
                    <th>Action</th>
                </tr>
                <c:forEach items="${items}" var="item">
                    <tr>
                    <td>${item.id }</td>
                    <td>${item.productName }</td>
                    <td>${item.cost }</td>
                    <td>${item.productDescription }</td>
                    <td>
                      <label>Quantity
           				 <select name="quantity" required>
               				 <option value="1">1</option>
              				 <option value="2">2</option>
               				 <option value="3">3</option>
              				 <option value="4">4</option>
              				 <option value="5">5</option>
           				 </select>
        			</label>
                        <a href="addnewitem?id=${item.id}&amount=${item.cost}">Add To Kit</a> 
                        
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