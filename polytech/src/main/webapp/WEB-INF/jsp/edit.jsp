<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>edit</title>
<script>
	
	// 전화번호 입력란 추가
	function addRow() {
		var table = document.getElementById('area');
		var rowsCount = table.rows.length;
		var insert = table.insertRow(rowsCount);
		var phonenum = "<input type='text' name='phonenum'/>";
		insert.insertCell().innerHTML = phonenum;
	}
	
	// 전화번호 입력란 삭제
	function delRow() {
		var table = document.getElementById('area');
		var rowsCount = table.rows.length;
		if(rowsCount == 2) {
			alert('더 이상 삭제할 수 없습니다.');
			return;
		}
		table.deleteRow(rowsCount-1);
	}
	
	// 저장 전 유효성 검사
	function check_form() {
		var name = edit_form.name.value;
		var phonenum = edit_form.phonenum.value;
		var email = edit_form.email.value;
		
		if(name == '') {
			alert('성명을 작성해주세요');
			edit_form.name.focus();
			return false;
		}
		
		if(email == '') {
			alert('이메일을 작성해주세요');
			edit_form.email.focus();
			return false;
		}
		
		var regularExpression = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
		
		if(!regularExpression.test(email)) {
			alert('이메일 형식이 잘못되었습니다.');
			edit_form.email.focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<h1>Edit Member</h1>  
	<form name='edit_form' action='editsave' onSubmit='return check_form()'>
		<input type='hidden' name='key' value='${id}'>
		성&nbsp;&nbsp;명 : <input type='text' name='name' value='${name}'/><br/>
		E-mail : <input type='text' name='email' value='${email}'/><br/><br/>
		<input type='button' value='추가' onClick='addRow()'/>
		<input type='button' value='삭제' onClick='delRow()'/>
		<input type='submit' value='저장'/><br/><br/>
		<table id='area' border='2'>
			<tr>
				<th>전화번호</th>
			</tr>
			<c:forEach var="i" begin="1" end="${phones.size()}" step="1">
			<tr>
				<td><input type='text' name='phonenum' value='${phones[i-1].num}'/><br/></td>
			</tr>
			</c:forEach>
			<tr>
				<td><input type='text' name='phonenum' /></td>
			</tr>
		</table>
	</form>
</body>
</html>