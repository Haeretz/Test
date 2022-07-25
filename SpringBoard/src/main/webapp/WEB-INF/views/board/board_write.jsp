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
	<div class="text-left">
		<a class="btn btn-default" href="#" id="back"> <span
			class="glyphicon glyphicon-arrow-left"></span>뒤로</a>
	</div>
	<form role="form" class="form-horizontal" method="POST"
		enctype="multipart/form-data">
		<div class="form-group form-group-sm">
			<label for="title" class="col-sm-2">제목</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="title">
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label for="writer" class="col-sm-2">작성자</label><br />
			<div class="col-sm-10">
				<input type="text" class="form-control" name="writer">
				<!-- 
				<p class="form-contron-static">${sessionScope.member.userId}</p>
				<input type="hidden" class="form-control" name="writer"
					value="${sessionScope.member.userId}">
			 -->
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label for="password" class="col-sm-2">비밀번호</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" name="password" />
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label for="file" class="col-sm-2">첨부파일</label>
			<div class="col-sm-10">
				<input type="file" class="form-control" name="file" /> <input
					type="file" class="form-control" name="file" /> <input type="file"
					class="form-control" name="file" />
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label for="content" class="col-sm-2">내용</label>
			<div class="col-sm-10">
				<textarea id="content" name="content"></textarea>
			</div>
		</div>
		<div class="text-right"></div>
		<p>
			<a href="#" id="reset">취소</a> <a href="#" id="submit">확인</a>
		</p>
	</form>
</body>
</html>