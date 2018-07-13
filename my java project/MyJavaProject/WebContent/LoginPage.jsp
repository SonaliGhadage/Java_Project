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
            <form action="loginsuccess" method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Login
                </h2>
            </caption>
		
			<tr>
                <th>Username: </th>
                <td>
                    <input type="text" name="un" size="45"
                            value='${un}'
                        />
                </td>
            </tr>
            
            <tr>
                <th>Password: </th>
                <td>
                    <input type="text" name="pw" size="45"
                            value='${pw}' 
                        />
                </td>
            </tr>
			
		  <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Submit" />
                </td>
            </tr>
        </table>
        </form>
    </div>
</body>
</html>