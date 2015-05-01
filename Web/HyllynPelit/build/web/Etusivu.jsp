
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
        <t:kirjautunut pageTitle="Etusivu">

        </t:kirjautunut>
        <title>Etusivu</title>
    </head>
    <body>
        <div class="pieniReunus">
            <h1>Etusivu</h1>

            <c:if test="${fn:contains(KirjautumisTilanne, 'Et ole kirjautunut sisään')}">
                <form action="Kirjautuminen" method="POST">
                    <input type="hidden" name="lahde" value="Etusivu"/>
                    <button type="submit" class="btn btn-default"  style="float: right">Kirjaudu sisään</button>
                    <button type="submit" class="btn btn-default" name="uusi" value="uusi" style="float: right">Rekistöröidy!</button>

                </form>

            </c:if>
            <c:if test="${fn:contains(KirjautumisTilanne, 'Kirjautunut sisään käyttäjällä: ')}">
                <form action="KirjauduUlos" method="POST">
                    <button type="submit" class="btn btn-default"  style="float: right">Kirjaudu Ulos</button>
                </form>
            </c:if>
        </div>
        <br>
        <ul class="nav nav-tabs">
            <li class="active"><a> Etusivu </a></li>
            <li><a href="${pageContext.request.contextPath}/Pelit">Pelit</a></li>
            <li> <a href="${pageContext.request.contextPath}/Arvostelut">Arvostelut</a></li>
            <li><a href="${pageContext.request.contextPath}/Kommentit">Kommentit</a></li>
        </ul>

        <c:if test="${ilmoitus != null}">
            <div class="alert alert-info">${ilmoitus}</div>
        </c:if>
        <div class="pieniReunus">
            <h3> Tietokannan kuvaus </h3>
            <div>Tämä sivu on tarkoitettu pelien vertailuun ja listaamiseen.</div>
            <div>Sivulla pystyy antaman Arvosteluita ja kommentteja peleille.</div>
            <div>Pelejä pystyy lisäämään ja arvostelemaan kuka tahansa sisäänkirjautunut!</div>
        </div>
    </body>
</html>



