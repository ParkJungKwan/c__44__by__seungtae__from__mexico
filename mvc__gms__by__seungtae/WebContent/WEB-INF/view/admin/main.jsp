<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<!doctype html>
<html lang="en">
	<jsp:include page="../common/head.jsp"/>
<body>
<div id="wrapper">
	<div id="header">
		<jsp:include page="../common/title_box.jsp"/>
		<jsp:include page="../common/menu_box.jsp"/>
	</div> 
	<div id="content">
		<jsp:include page="../member/search.jsp"/>
	</div> 
	<div id="footer">
		 <jsp:include page="../common/footer_box.jsp"/>	
	</div>
</div>
<script>
	admin.main('${context}');
</script>	
</body>
</html>





