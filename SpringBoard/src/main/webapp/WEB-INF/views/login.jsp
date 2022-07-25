<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>
	<form role="form" class="form-inline" method="POST">
		<div class="form-group">
			<label for="userId">ID</label> <input type="text"
				class="form-control" name="userId" placeholder="Enter userid">
		</div>
		<div class="form-group">
			<label for="password">Password</label> <input type="password"
				class="form-control" name="password" placeholder="Enter password">
		</div>
		<input type="submit" class="btn btn-default" value="로그인" />
	</form>
</body>
</html>