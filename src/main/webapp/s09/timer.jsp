<%@ page import="java.time.LocalTime"%>    <!--  JSP è codice HTML condita con metodi Java, 
												 viene chiamata durante la request a s09/timer.jsp
												 TOMCAT trasforma qusto file in un Servlet -->
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Hello JSP</title>
</head>
<body>
    <h1>
        <%    //defines the Java environment. out è l'oggetto di response
            out.print(LocalTime.now());
        %>
    </h1>
</body>
</html>