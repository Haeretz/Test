<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "dao.*" %>
<%@ page import = "java.util.List" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<%@ include file="color.jspf"%>
 
<%!
    SimpleDateFormat sdf = 
        new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>
<%
	List articleList = (List)request.getAttribute("result");    
	int pageNum = 1;
	if (request.getParameter("pageNum") != null) {
		pageNum = Integer.parseInt(request.getParameter("pageNum"));
	}
	PageVO page_vo = (PageVO)request.getAttribute("page");
	if (articleList == null && page_vo == null) {
%>
		<script>
		location.href="<%=request.getContextPath()%>/ibatis/getList?pageNum=<%=pageNum%>";
		</script>
<%		
	} else {
%>
<html>
<head>
<title>게시판</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>

<body bgcolor="<%=bodyback_c%>">
<center><b>글목록(전체 글:<%=page_vo.getCount()%>)</b>
<table width="700">
<tr>
    <td align="right" bgcolor="<%=value_c%>">
    <a href="<%=request.getContextPath()%>/board/writeForm.jsp">글쓰기</a>
    </td>
</table>

<%
	//List articleList = (List)request.getAttribute("result");
	if (articleList == null) {
%>
		<table width="700" border="1" cellpadding="0" cellspacing="0">
			<tr>
    		<td align="center">
    			게시판에 저장된 글이 없습니다.
    		</td>
		</table>
<%  } else {    %>
		<table border="1" width="700" cellpadding="0" cellspacing="0" align="center"> 
    		<tr height="30" bgcolor="<%=value_c%>"> 
      		<td align="center"  width="50"  >번 호</td> 
      		<td align="center"  width="250" >제   목</td> 
      		<td align="center"  width="100" >작성자</td>
      		<td align="center"  width="150" >작성일</td> 
      		<td align="center"  width="50" >조 회</td> 
      		<td align="center"  width="100" >IP</td>    
    		</tr>
<%  System.out.println(articleList.size());
        	for (int i=0; i < articleList.size() ; i++) {
				BoardVO article = (BoardVO)articleList.get(i);
%>
				<tr height="30">
				<td align="center"  width="50" > <%=article.getNum()%></td>
				<td  width="250" >
<%
				int wid=0; 
				if(article.getRe_level()>0){
					wid=5*(article.getRe_level());
%>
					<img src="<%=request.getContextPath()%>/board/images/level.gif" width="<%=wid%>" height="16">
					<img src="<%=request.getContextPath()%>/board/images/re.gif">
<%
				}else{%>
					<img src="<%=request.getContextPath()%>/board/images/level.gif" width="<%=wid%>" height="16">
<%
				}%>
           
      			<a href="<%=request.getContextPath()%>/ibatis/content?num=<%=article.getNum()%>&pageNum=<%=page_vo.getPageNum()%>">
				<%=article.getSubject()%></a> 
<%
				if(article.getReadcount()>=20){%>
					<img src="<%=request.getContextPath()%>/board/images/hot.gif" border="0"  height="16"><%}%> </td>
					<td align="center"  width="100"> 
					<a href="mailto:<%=article.getEmail()%>"><%=article.getWriter()%></a></td>
					<td align="center"  width="150"><%= sdf.format(article.getReg_date())%></td>
					<td align="center"  width="50"><%=article.getReadcount()%></td>
					<td align="center" width="100" ><%=article.getIp()%></td>
					</tr>
<%
				}%>
			</table>
<%
		}%>

<%
    if (page_vo.getCount() > 0) {
        int pageCount = page_vo.getCount() / page_vo.getPageSize() + ( page_vo.getCount() % page_vo.getPageSize() == 0 ? 0 : 1);
		 
        int startPage = (int)(page_vo.getPageNum()/10)*10+1;
		int pageBlock=10;
        int endPage = startPage + pageBlock-1;
        if (endPage > pageCount) endPage = pageCount;
        
        if (startPage > 10) {    %>
        <a href="<%=request.getContextPath()%>/board/list.jsp?pageNum=<%= startPage - 10 %>">[이전]</a>
<%      }
        for (int i = startPage ; i <= endPage ; i++) {  %>
        <a href="<%=request.getContextPath()%>/board/list.jsp?pageNum=<%= i %>">[<%= i %>]</a>
<%
        }
        if (endPage < pageCount) {  %>
        <a href="<%=request.getContextPath()%>/board/list.jsp?pageNum=<%= startPage + 10 %>">[다음]</a>
<%
        }
    }
%>
</center>
</body>
</html>
<%		
	}
%>


