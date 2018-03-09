����һ����Դ��JSPģ���ǩ������ͳһҳ��Ĳ��֡�

ʹ�÷�����

1. ����һ��ģ�塣ģ��������Ҫ������ <t:template></t:template> �ڡ�
	�磺
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

2. ʹ��ģ��

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

    ��ģ���е� section �ж�������� ���Խ��� ɾ����ǰ��׷�ӣ��滻������
    ���ʡ�ԣ������ģ���ж�������ݡ�
    �滻������Ҳ����Ƕ��ʹ��ģ�塣ģ�嶨������Ҳ����ʹ�� <t:use> ��ǩǶ������ģ�塣
    
    ģ�屾��Ҳ����ֱ��������ʾ��

3. �߼�ʹ��
   Ϊ�˱��⵱ģ���ļ��ķ���λ�ñ�������´�������ʹ�ø�ģ���ļ���jsp��t:use ��ǩ��page����ֵ�����޸ĵĲ�����
   ����ʹ�� <t:use name="common"> �ķ�ʽָ��ģ��
   <t:include> ��ǩ Ҳ����ʹ�� name ����
   
   name��ʵ��page��ӳ���ϵ������ WEB-INF/template.properties �ļ���
   �磺
   common=/template.jsp
   
   templates.properties�ļ���λ��Ҳ������web.xml��ָ����
   ָ����ʽ��
   	<context-param>
		<param-name>PageMapFilePath</param-name>
		<param-value>WEB-INF/template.properties</param-value>
   	</context-param>
   	
   