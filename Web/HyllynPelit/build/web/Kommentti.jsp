
<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/bootstrap-theme.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <t:kirjauduNappi pageTitle="Kommentit">

        </t:kirjauduNappi>
        <t:kirjautunut pageTitle="Kommentti">

        </t:kirjautunut>
        <title>kommentti</title>
    </head>
    <body>
        <h1>Kommentti</h1>

        <ul class="nav nav-tabs">
            <li><a href="${pageContext.request.contextPath}/Etusivu"> Etusivu </a></li>
            <li><a href="${pageContext.request.contextPath}/Pelit">Pelit</a></li>
            <li> <a href="${pageContext.request.contextPath}/Arvostelut">Arvostelut</a></li>
            <li><a href="${pageContext.request.contextPath}/Kommentit">Kommentit</a></li> 
        </ul>

        <div>
            <h4>Pelin nimi: Mass effect</h4>
            <h3>Kommentti:</h3>
            Tähän tulee jotakin tämän kaltaista.
        </div>

    </body>
</html>
