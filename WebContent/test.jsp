<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="t" uri="http://www.qkinfotech/jsp/jstl/template"%>

hello ${param.name}

<t:use page="/template.jsp">
	<t:remove section="meta"/>
	<t:append section="include">
		<script>
			var a= 1;
		</script>
	</t:append> 
	<t:replace section="body" >
		<c:out value="bbb"/>
		
	</t:replace> 
	<t:prepend section="footer">
		<div>fotter2</div>
	</t:prepend> 
</t:use>