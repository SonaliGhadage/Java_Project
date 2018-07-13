<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Identity Management System</title>
</head>
<body>
<center>
		 <h1>Identity Management System</h1>
        <h2>
            <a href="new"><font size="4" color="violet"> Add New Identity </font></a>
            &nbsp;&nbsp;&nbsp;
            <a href="list"><font size="4" color="violet">List All Identities</font></a>
            &nbsp;&nbsp;&nbsp;
            <a href="searchID"><font size="4" color="violet">Search Identity</font></a>
           
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Identities</h2></caption>
            <tr>
                <th>USER_ID</th>
                <th>NAME</th>
                <th>EMAIL_ID</th>
                  <th>ACTIONS</th>
            </tr>
            <c:forEach var="IDEN" items="${listIdentity}">
                <tr>
                    <td><c:out value="${IDEN.USER_ID}" /></td>
                    <td><c:out value="${IDEN.NAME}" /></td>
                    <td><c:out value="${IDEN.EMAIL_ID}" /></td>
                    <td>
                        <a href="edit?USER_ID=<c:out value='${IDEN.USER_ID}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;
                        <a href="delete?USER_ID=<c:out value='${IDEN.USER_ID}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>
