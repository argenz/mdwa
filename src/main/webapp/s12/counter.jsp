<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!-- direttiva di pagina  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Hello JSP</title>
</head>
<body>

    <%@include file="header.html"%>      <!-- direttiva include permette di mettere un file html in un altro, molto utile per gli headers e i footers-->
    
    <%-- Just as example, this is a JSP comment that is not preserved in the source code, unlike the html comment--%>
    
    <%!int unreliableCounter = 0;%> 
    
    <h1>
        <%
            out.print("Counter was " + unreliableCounter);
        %>
        now is
        <%=++unreliableCounter%>  <%--  --%>
    </h1>
    <%@include file="footer.html"%>
</body>
</html>