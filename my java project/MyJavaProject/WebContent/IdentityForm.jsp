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

<!-- <center>
         <h1>
            <a href="new"><font size="4" color="violet">Add New Identity</font></a>
            &nbsp;&nbsp;&nbsp;
            <a href="list"><font size="4" color="violet">List All Identities</font></a>
             
        </h1>-->
        
    </center> <div align="center">
        <c:if test="${IDEN != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${IDEN == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${IDEN != null}">
                       Edit Identity
                    </c:if>
                    <c:if test="${IDEN == null}">
                       Add New Identity
                    </c:if>
                </h2>
            </caption>
           <tr>
                <th>USER_ID: </th>
                <td>
                    <input type="text" name="USER_ID" size="45"
                            value='${IDEN.USER_ID}'
                        />
                </td>
            </tr>
            
            <tr>
                <th>NAME: </th>
                <td>
                    <input type="text" name="NAME" size="45"
                            value='${IDEN.NAME}' 
                        />
                </td>
            </tr>
            <tr>
                <th>EMAIL_ID: </th>
                <td>
                    <input type="text" name="EMAIL_ID" size="45"
                            value='${IDEN.EMAIL_ID}' 
                    />
                </td>
            </tr>
           
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div>
</body>
</html>