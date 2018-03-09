这是一个开源的JSP模板标签。用于统一页面的布局。

使用方法：

1. 定义一个模板。模板内容需要定义在 <t:template></t:template> 内。
	如：
	<%@page language="java" pageEncoding="UTF-8"%>
	<%
		response.setHeader("Cache-Control", "no-cache,no-store");//HTTP 1.1
		response.setDateHeader("Expires", 0); //prevent caching at the proxy server
		response.setHeader("Pragma", "no-cache"); //HTTP 1.0
	%>
	
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

2. 使用模板

	<%@page language="java" pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="t" uri="http://www.qkinfotech/jsp/jstl/template"%>
	
	<t:use page="/template.jsp">
		<t:remove section="meta"/>
		<t:prepend section="include">
			<script>
				var a= 1;
			</script>
		</t:prepend> 
		<t:replace section="body" >
			<c:out value="aaa"/>
			<t:include page="/test.jsp">
				<t:param name="name" value="ssss"/>
			</t:include>
		</t:replace> 
		<t:append section="footer">
			<div>footer2</div>
		</t:append> 
	</t:use>

    对模板中的 section 中定义的内容 可以进行 删除，前后追加，替换操作。
    如果省略，则输出模板中定义的内容。
    替换的内容也可以嵌套使用模板。模板定义里面也可以使用 <t:use> 标签嵌入其他模板。
    
    模板本身也可以直接用来显示。

3. 高级使用
   为了避免当模板文件的放置位置变更，导致大批量对使用该模板文件的jsp中t:use 标签的page属性值进行修改的操作。
   可以使用 <t:use name="common"> 的方式指定模板
   <t:include> 标签 也可以使用 name 属性
   
   name和实际page的映射关系定义在 WEB-INF/template.properties 文件中
   如：
   common=/template.jsp
   
   templates.properties文件的位置也可以在web.xml中指定。
   指定方式：
   	<context-param>
		<param-name>PageMapFilePath</param-name>
		<param-value>WEB-INF/template.properties</param-value>
   	</context-param>
   	
   