<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>상세보기</title>
<script>

	// 회원 삭제 전 확인창으로 한번 더 삭제 여부 확인
    function checkDelete() {
        var answer = confirm('해당 회원에 대한 정보가 모두 사라집니다. 삭제하시겠습니까?');
        if(answer == true)
        	location.href = "delete?key=${id}";
       	else
       		return;
    }
</script>
</head>
<body>
	<h1>Member View</h1>  
	<table border="2" width="400" cellpadding="2">
	<tr>
        <th width=150 align='center'>성&nbsp;&nbsp;&nbsp;&nbsp;명</th>
        <td width=250 align='center'>${name}</td>
    </tr>
    <tr>
        <th width=150 align='center'>E-mail</th>
        <td width=250 align='center'>${email}</td>
    </tr>
    <c:forEach var="i" begin="1" end="${phones.size()}" step="1">
    <tr>
         <th width=150 align='center'>전화번호 ${i}</th>
         <td width=250 align='center'>${phones[i-1].num}</td>
    </tr>	
    </c:forEach>
    </table>
    <br/>
    <table border="0" width="400">
	    <tr>
	    	<td width="80%"></td>
	    	<td>
	    	<input type=button value="수정" OnClick="location.href='edit?key=${id}'"></td>
	    	<td>
	    	<input type=button value="삭제" OnClick="checkDelete()">
	    	</td>
	    	
	    </tr>
    </table> 
</body>
</html>