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
	<div class="text-left">[총:${total}개] [${page} / ${totalPage}]</div>
	<a href="write">글쓰기</a>
	<!--<c:if test="${!empty sessionScope.member }">
	<div class="text-right">
		<c:url value="${contextPath}/write" var="writeUrl" />
		<a href="${writeUrl}"><span class="glyphicon glyphicon-pencil"></span>글작성</a>
	</div>
	</c:if>-->
	<table class="table table-hover table-responsive">
		<thead>
			<tr>
				<th>No</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="board" items="${list}">
				<tr>
					<td>${board.num}</td>
					<td><c:forEach begin="1" end="${board.reLevel}">&nbsp;&nbsp;&nbsp;&nbsp;</c:forEach>
						<c:if test="${board.reLevel > 0}">[RE]</c:if><a href="view?num=${board.num}">${board.title}</a></td>
					<td>${board.writer}</td>
					<td>${board.readCount}</td>
					<td><fmt:formatDate value="${board.regDate}"
							pattern="yyyy-MM-dd" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="text-center">
		<ul class="pagination pagination-sm">
			<c:forEach begin="1" end="${totalPage}" varStatus="status">
				<c:if test="${page == status.index}">
					<li class="active"><a href="#">${status.index}</a></li>
				</c:if>
				<c:if test="${page != status.index}">
					<li><a href="list.do?page=${status.index}">${status.index}</a></li>
				</c:if>
			</c:forEach>
		</ul>
	</div>
</body>
</html>