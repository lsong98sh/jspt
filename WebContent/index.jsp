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

<t:use name="template">
	<t:remove section="meta"/>
	<t:prepend section="include">
		<script>
			var a= 1;
		</script>
	</t:prepend> 
	<t:replace section="body" >
		<c:out value="aaa"/>
		<t:include name="test">
			<t:param name="name" value="ssss"/>
		</t:include>
	</t:replace> 
	<t:append section="footer">
		<div>fotter2</div>
	</t:append> 
</t:use>
