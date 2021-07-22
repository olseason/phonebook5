<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>전화번호 수정</h1>
	<p>수정화면 입니다. 아래 항목을 수정하고 "수정" 버튼을 클릭하세요.</p>

	<form action="/phonebook3/modify" method="post">

		이름: <input type="text" name="name" value="${ requestScope.personInfo.name }"> <br> 
		핸드폰: <input type="text" name="hp" value="${ requestScope.personInfo.hp }"> <br> 
		회사: <input type="text" name="company" value="${ requestScope.personInfo.company }"> <br> 
		<input type="hidden" name="personID" value="${ requestScope.personInfo.personID }"> <br>

		<button type="submit">수정</button>

	</form>

</body>
</html>