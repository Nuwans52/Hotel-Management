<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<tiles:importAttribute name="scriptjs" />
<tiles:importAttribute name="styless" />

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	var context = '<%=request.getContextPath()%>';
</script>
<!-- Page title -->
<title><tiles:insertAttribute name="title" ignore="true" /></title>

<!-- styles -->
<c:forEach var="styles" items="${styless}">
	<link rel="stylesheet" href="<c:url value="${styles}"/>"></link>
</c:forEach>
<!-- end styles -->

</head>
<body style="background-color: #F8FFEE;">
	<!--header-->
	<tiles:insertAttribute name="header" />

	<!--aside-->
	<tiles:insertAttribute name="sidebar" />

	<!-- Main Wrapper -->
	<div id="wrapper">
		<tiles:insertAttribute name="body" />

		<!-- Footer-->
		<tiles:insertAttribute name="footer" />
	</div>
</body>
<!-- scripts -->
<c:forEach var="script" items="${scriptjs}">
	<script src="<c:url value="${script}"/>"></script>
</c:forEach>
<!-- end scripts -->
</html>