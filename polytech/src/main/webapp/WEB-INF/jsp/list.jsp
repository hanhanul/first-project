<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>read</title>
</head>
<body>
	<h1>Members List</h1>
	<form name='fm' action='list' method='post'>
	<table border="0" width="350" cellpadding="2">
		<tr align="right">
			<td>성&nbsp;&nbsp;&nbsp;&nbsp;명 : <input type='text' name='name_search'/> <input type='submit' value='검색'/></td>
		</tr>
		<tr align="right">
			<td>전화번호 : <input type='text' name='phone_search'/> <input type='submit' value='검색'/></td>
		</tr>
	</table>
	</form>
	<br/>
	<table border="2" width="350" cellpadding="2">
	<tr>
        <th width=50 align='center'>Id</th>
        <th width=250 align='center'>Name</th>
    </tr>
    <c:choose>
		<c:when test="${members.isEmpty()}">
			<tr>
		         <td colspan='2' align='center'>등록된 사용자가 없습니다.</td>
		    </tr>
		</c:when>
		
		<c:otherwise>
		    <c:forEach items="${members}" var="member" varStatus="status">
			    <tr>
			         <td width=50 align='center'>${status.count}</td>
			         <td width=250 align='center'><a href='view?key=${member.id}'>${member.name}</a></td>
			    </tr>	
		    </c:forEach>
	    </c:otherwise>
	</c:choose>
    </table>  
    <br/>  
    <a href="insert">Add New Member</a>
</body>
</html>