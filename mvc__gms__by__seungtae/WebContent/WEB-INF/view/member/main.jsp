<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
	<jsp:include page="../common/head.jsp"/>
<body>
<div id="wrapper">
	<div id="header">
		<jsp:include page="../common/title_box.jsp"/>
		<jsp:include page="menu_box.jsp"/>
	</div> 
	<div id="content">
	<c:choose>
	    <c:when test="${pagename eq 'add'}">
	        <jsp:include page="add.jsp"/> 
	    </c:when>
	    <c:when test="${pagename eq 'login'}">
	     	<jsp:include page="login.jsp"/>
	    </c:when>
	    <c:when test="${pagename eq 'search'}">
	       <jsp:include page="search.jsp"/>
	    </c:when>
	    <c:when test="${pagename eq 'modify'}">
	       <jsp:include page="modify.jsp"/>
	    </c:when>
	    <c:otherwise>
	         <jsp:include page="retrieve.jsp"/>
	    </c:otherwise>
	</c:choose>

	<div id="footer">
		 <jsp:include page="../common/footer_box.jsp"/>	
	</div>
</div></div>
<script>
	member.main('${context}');
</script>	
</body>
</html>





