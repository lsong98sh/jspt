<%@page language="java" pageEncoding="UTF-8"%>
<%
	response.setHeader("Cache-Control", "no-cache,no-store");//HTTP 1.1
	response.setDateHeader("Expires", 0); //prevent caching at the proxy server
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="t" uri="http://www.qkinfotech/jsp/jstl/template"%>
<t:template>
<!DOCTYPE html>
<html>
<head>
	<t:section name="meta">
		<meta content="telephone=no" name="format-detection" />
	</t:section>
	<t:section name="include">
		<script src="jquery.js"></script>
	</t:section>
</head>
<body>
	<t:section name="header">
		<div>default header</div>
	</t:section>
	<t:section name="body">
		<div>default body</div>
	</t:section>
	<t:section name="footer">
		<div>default footer</div>
	</t:section>
</body>
</html>
</t:template>