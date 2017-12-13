<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
123
<br>
	<table border="1">
        <tbody>
            <tr>
                <th>姓名</th>
                <th>手机号</th>
            </tr>
            <c:if test="${!empty listUser }">
                <c:forEach items="${listUser }" var="list">
                    <tr>
                        <td>${list.user_name }</td>
                        <td>${list.user_phone }</td>
                        
                    </tr>                
                </c:forEach>
            </c:if>
        </tbody>
    </table>
</body>
</html>