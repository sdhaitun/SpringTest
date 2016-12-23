<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="cm" uri="/WEB-INF/taglib/cm.tld" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <script type="text/javascript" src="<%=basePath %>js/jquery-2.1.1.js"></script>
    <%--<script>--%>
        <%--Date.prototype.format = function(fmt) {--%>
            <%--var o = {--%>
                <%--"M+" : this.getMonth()+1,                 //月份--%>
                <%--"d+" : this.getDate(),                    //日--%>
                <%--"h+" : this.getHours(),                   //小时--%>
                <%--"m+" : this.getMinutes(),                 //分--%>
                <%--"s+" : this.getSeconds(),                 //秒--%>
                <%--"q+" : Math.floor((this.getMonth()+3)/3), //季度--%>
                <%--"S"  : this.getMilliseconds()             //毫秒--%>
            <%--};--%>
            <%--if(/(y+)/.test(fmt)) {--%>
                <%--fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));--%>
            <%--}--%>
            <%--for(var k in o) {--%>
                <%--if(new RegExp("("+ k +")").test(fmt)){--%>
                    <%--fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));--%>
                <%--}--%>
            <%--}--%>
            <%--return fmt;--%>
        <%--}--%>
    <%--</script>--%>
    <script type="text/javascript">
        $(document).ready(function() {
            var imgCode = $('#code');
            $(imgCode).attr('src',"/captcha.png");
            $('#code').click(function(){
                $(this).attr('src',"/captcha.png");
            });

//            var a = "2012-03-02 02:03:31";
//            console.log('sf' + new Date(a).format("yyyy-MM-dd"));
        });
    </script>
</head>
<body>
<h2>Hello ${name}!</h2>
<cm:securityTag privilegeString="USER_ALTER">
    <h1>hh</h1>
</cm:securityTag>
<img id="code" src="" alt="" style="width:185px;float:right;margin-top:-66px;background:rgba(255,255,255,0.5);border-radius:2px;"/>
</body>
</html>
