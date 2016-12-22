<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <script type="text/javascript" src="<%=basePath %>/js/jquery-2.1.1.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
//            var imgCode = $('#code');
//            $(imgCode).attr('src',"captcha.png");
//            $('#code').click(function(){
//                $(this).attr('src',"captcha.png");
//            });

            console.log('<fmt:formatDate value="<%= new Date()%>" />');
            <fmt:parseDate  var="da" value="2012-03-03 02:03:31" type="DATE" pattern="yyyy-MM-dd HH:mm:ss"/>
            console.log('sf' + '<fmt:formatDate value="${da}" />');
            console.log('sf' + '<%= new Date()%>');
        });
    </script>
</head>
<body>
<h2>Hello ${name}!</h2>
<%--<img id="code" src="" alt="" style="width:185px;float:right;margin-top:-66px;background:rgba(255,255,255,0.5);border-radius:2px;"/>--%>
</body>
</html>
