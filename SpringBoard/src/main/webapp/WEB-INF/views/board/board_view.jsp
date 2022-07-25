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
		$("#delete").click(function(e) {
			e.preventDefault();
			var password = prompt("비밀번호를입력하세요");
			$.get({
				url : "delete?num=${board.num}&password=" + password,
				success : function(result) {
					result.trim();
					if (result == 'OK') {
						location = 'list';
					} else {
						alert("패스워드가틀렸습니다.");
					}
				}
			});
		});
	});
</script>
<title></title>
</head>
<body>
	<div class="text-left">
		<a class="btn btn-default" href="#" id="back"> <span
			class="glyphicon glyphicon-arrow-left"></span>뒤로
		</a>
	</div>
	<div>
		<a href="update?num=${board.num}">수정</a> | <a href="#" id="delete">삭제</a>
		| <a href="reply?num=${board.num}">댓글작성</a>
	</div>
	<form role="form" class="form-horizontal" action="delete.do"
		method="POST">
		<div class="form-group form-group-sm">
			<label class="col-sm-2">제목 </label>
			<div class="col-sm-8">
				<p class="form-control-static">${board.title}</p>
			</div>
			<div class="col-sm-2">
				<c:if test="${!empty sessionScope.member}">
					<c:url value="${contextPath}/board/update.do" var="updateUrl">
						<c:param name="num" value="${board.num}" />
					</c:url>
					<a class="btn btn-primary btn-xs" href="${updateUrl}">글수정</a>
					<a class="delete-board btn btn-warning btn-xs"
						href="../board/view.do" data-num="${board.num}">글삭제</a>
				</c:if>
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-sm-2">작성자</label>
			<div class="col-sm-10">
				<p class="form-control-static">${board.writer}</p>
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-sm-2">작성일</label>
			<div class="col-sm-10">
				<p class="form-control-static">
					<fmt:formatDate value="${board.regDate}" pattern="yyyy-MM-dd" />
				</p>
			</div>
		</div>
		<c:if test="${!empty fileList}">
			<div class="form-group form-group-sm">
				<label class="col-sm-2">첨부파일</label>
				<div class="col-sm-10">
					<c:forEach var="file" items="${fileList}">
						<a href="../file/view?num=${file.num}"> <span class="glyphicon glyphicon-floppy-disk"></span> ${file.name}
						</a>
					</c:forEach>
				</div>
			</div>
		</c:if>
		<div class="form-group form-group-sm">
			<label class="col-sm-2">내용</label>
			<div class="col-sm-10">
				<pre>${board.content}</pre>
			</div>
		</div>

		<div class="form-group form-group-sm reply-list"></div>
	</form>
</body>
</html>