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
		         
    </center> <div align="center">
             <form action="search" method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                       Search Identity
                   
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
                <td colspan="2" align="center">
                    <input type="submit" value="Search" />
                </td>
            </tr>
        </table>
       </form>
    </div>
</body>
</html>