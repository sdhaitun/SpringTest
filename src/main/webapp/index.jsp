<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
    <script type="text/javascript" src="<%=basePath %>/js/jquery-2.1.1.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            var imgCode = $('#code');
            $(imgCode).attr('src',"captcha.png");
            $('#code').click(function(){
                $(this).attr('src',"captcha.png");
            });
        });
    </script>
</head>
<body>
<h2>Hello ${name}!</h2>
<img id="code" src="" alt="" style="width:185px;float:right;margin-top:-66px;background:rgba(255,255,255,0.5);border-radius:2px;"/>
</body>
</html>
