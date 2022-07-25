<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-1.12.0.min.js"></script>
<script>
	$(document).ready(function() {
		$("#back").click(function() {
			history.back();
		});

		$("#reset").click(function(e) {
			e.preventDefault();
			$("form")[0].reset();
		});

		$("#submit").click(function(e) {
			e.preventDefault();

			if ($("[name=title]").val() == '') {
				$("[name=title]").focus();
				return;
			}

			if ($("[name=writer]").val() == '') {
				$("[name=writer]").focus();
				return;
			}

			if ($("[name=password").val() == '') {
				$("[name=password]").focus();
				return;
			}

			$("form")[0].submit();
		});
	});
</script>
<title></title>
</head>
<body>
	<form method="POST">
	<div class="form-group form-group-sm">
			<label for="title" class="col-sm-2">제목</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="title" value="${board.title}">
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label for="password" class="col-sm-2">비밀번호</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" name="password" />
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label for="content" class="col-sm-2">내용</label>
			<div class="col-sm-10">
				<textarea id="content" name="content">${board.content}</textarea>
			</div>
		</div>
		<p>
			<a href="#" id="submit">확인</a> | <a href="#" id="reset">취소</a> | <a
				href="#" id="back">돌아가기</a>
		</p>
	</form>
</body>
</body>
</html>