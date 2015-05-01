
<%@page contentType="text/html" pageEncoding="ISO-8859-1" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/bootstrap-theme.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
    <div class="pieniReunus">
        <c:if test="${fn:contains(KirjautumisTilanne, 'Et ole kirjautunut sisään')}">
            <form action="Kirjautuminen" method="POST">
                <input type="hidden" name="lahde" value="Arvostelut"/>
                <button type="submit" class="btn btn-default"  style="float: right">Kirjaudu sisään</button>
            </form>
        </c:if>
        <c:if test="${fn:contains(KirjautumisTilanne, 'Kirjautunut sisään käyttäjällä: ')}">
            <form action="KirjauduUlos" method="POST">
                <button type="submit" class="btn btn-default"  style="float: right">Kirjaudu Ulos</button>
            </form>
        </c:if>   
        <t:kirjautunut pageTitle="Kommentit">

        </t:kirjautunut>
        <title>Kommentit</title>
    </div>
</head>
<body>
    <div class="pieniReunus">
        <h1>Kommentit</h1>
    </div> 
    <br>

    <div class="container" style="float: right">
        <form class="form-horizonal" role="form" action="HakuToimintoKommentit" method="POST">
            <div class="input-group">
                <input name="hakuSana" type="text" class="form-control" placeholder="Pelin nimi/ lisääjä">
                <span class="input-group-btn">
                    <button type="submit" class="btn btn-default" type="button">hae!</button>
                </span>
            </div>
        </form>
    </div>

    <ul class="nav nav-tabs">
        <li><a href="${pageContext.request.contextPath}/Etusivu"> Etusivu </a></li>
        <li><a href="${pageContext.request.contextPath}/Pelit">Pelit</a></li>
        <li> <a href="${pageContext.request.contextPath}/Arvostelut">Arvostelut</a></li>

        <li class="active"><a>Kommentit</a></li> 
    </ul>
    <div class="pieniReunus">
        <h6>Pelejä yhteensä: ${kommenttienmaara}</h6>
    </div>
    <br>
    <br>
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>Nimi</th>
                <th>Kommentti</th>
                <th>Kirjoittaja</th>


            </tr>
            <tr>
                <TD> <c:forEach var="Kommentti" items="${kommentit}">
                        <div class="Kommentti"></div>
                        <c:out value="${Kommentti.nimi}"/>
                    </c:forEach>
                </TD>
                <TD> <c:forEach var="Kommentti" items="${kommentit}">
                        <div class="Kommentti"></div>
                        <c:out value="${Kommentti.kommentti}"/>
                    </c:forEach>
                </TD>
                <TD> <c:forEach var="Kommentti" items="${kommentit}">
                        <div class="Kommentti"></div>
                        <c:out value="${Kommentti.tunnus}"/>
                    </c:forEach>
                </TD>
            </tr>
        </thead>
    </table>
</body>
</html>
