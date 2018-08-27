<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script>
	function addRow() {
		var table = document.getElementById('area');
		var rowsCount = table.rows.length;
		var insert = table.insertRow(rowsCount);
		var phonenum = "<input type='text' name='phonenum'/>";
		insert.insertCell().innerHTML = phonenum;
	}
	
	function delRow() {
		var table = document.getElementById('area');
		var rowsCount = table.rows.length;
		if(rowsCount == 2) {
			alert('더 이상 삭제할 수 없습니다.');
			return;
		}
		table.deleteRow(rowsCount-1);
	}
	
	function check_form() {
		var name = add_form.name.value;
		var phonenum = add_form.phonenum.value;
		var email = add_form.email.value;
		
		if(name == '') {
			alert('성명을 작성해주세요');
			add_form.name.focus();
			return false;
		}
		
		if(email == '') {
			alert('이메일을 작성해주세요');
			add_form.email.focus();
			return false;
		}
		
		var regularExpression = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
		
		if(!regularExpression.test(email)) {
			alert('이메일 형식이 잘못되었습니다.');
			add_form.email.focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<h1>Add Member</h1>  
	<form name='add_form' action='save' onSubmit='return check_form()'>
		성&nbsp;&nbsp;명 : <input type='text' name='name'/><br/>
		E-mail : <input type='text' name='email'/><br/><br/>
		<input type='button' value='추가' onClick='addRow()'/>
		<input type='button' value='삭제' onClick='delRow()'/>
		<input type='submit' value='저장'/><br/><br/>
		<table id='area' border='2'>
			<tr>
				<th>전화번호</th>
			</tr>
			<tr>
				<td><input type='text' name='phonenum' /></td>
			</tr>
		</table>
	</form> 
</body>
</html>