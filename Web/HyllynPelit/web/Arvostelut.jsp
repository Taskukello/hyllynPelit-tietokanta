

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/bootstrap-theme.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">

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
    <t:kirjautunut pageTitle="Arvostelut">

    </t:kirjautunut>
    <title>Arvostelut</title>

</head>
<body>
    <h1>Arvostelut</h1>

    <div class="row" style="float: right">

        <div class="col-lg-6" style="float: right">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Pelin nimi">
                <span class="input-group-btn">
                    <button class="btn btn-default" type="button">hae!</button>
                </span>
            </div><!-- /input-group -->
        </div><!-- /.col-lg-6 -->
    </div><!-- /.row -->
    <ul class="nav nav-tabs">
        <li><a href="${pageContext.request.contextPath}/Etusivu"> Etusivu </a></li>
        <li><a href="${pageContext.request.contextPath}/Pelit">Pelit</a></li>
        <li class="active"> <a>Arvostelut</a></li>
        <li><a href="${pageContext.request.contextPath}/Kommentit">Kommentit</a></li> 
    </ul>
    <c:if test="${ilmoitus != null}">
        <div class="alert alert-info">${ilmoitus}</div>
    </c:if>
    <h6>Rivejä yhteensä: <c:out value="${ArvosteluidenMaara}"/></h6>


    <c:if test="${fn:contains(KirjautumisTilanne, 'Et ole kirjautunut sisään')}">
        <form class="form-horizonal" style="float: right" role="form" action="ApuKirjaus" method="POST">
            <input class="form-group" type="hidden"  name="lahde" value="Arvostelut">


            <button type="submit"  class="btn btn-default">Muokkaa</button>
            <button type="submit"  class="btn btn-default">Lisää Arvostelu</button>
        </form>
    </c:if>
    <c:if test="${fn:contains(KirjautumisTilanne, 'Kirjautunut sisään käyttäjällä: ')}">
        <a class="btn btn-default" href="${pageContext.request.contextPath}/LisaaArvostelu" role="button" style="float: right;" >Lisää Arvostelu</a>
        <div class="form-group" style="float: right; ">
            <form class="form-horizonal" role="form" action="MuokkaaArvosteluja" method="POST">
                <select name="muokattavanNimi">
                    <c:forEach var="Peli" items="${pelit}">
                        <option value="${Peli.peli}">${Peli.peli}</option>

                    </c:forEach>    

                </select>
                <button type="submit" class="btn btn-default">Muokkaa</button>
            </form>
        </div>

    </c:if>


    <table class="table table-bordered">
        <thead>
            <tr>
                <th>Nimi</th>
                <th>Julkaisuvuosi</th>
                <th>Arvostelu</th>
                <th>Arvostelun lisäyspäivä</th>
                <th>Lisääjä</th>



            </tr>
            <tr>
                <TD> <c:forEach var="Arvostelu" items="${arv}">
                        <div class="Arvostelu"></div>
                        <c:out value="${Arvostelu.nimi}"/>
                    </c:forEach>
                </TD>
                <TD> <c:forEach var="Arvostelu" items="${arv}">
                        <div class="Arvostelu"></div>
                        <c:out value="${Arvostelu.vuosi}"/>
                    </c:forEach>
                </TD>
                <TD> <c:forEach var="Arvostelu" items="${arv}">
                        <div class="Arvostelu"></div>
                        <c:out value="${Arvostelu.arvosana}"/>
                    </c:forEach>
                </TD>
                <TD> <c:forEach var="Arvostelu" items="${arv}">
                        <div class="Arvostelu"></div>
                        <c:out value="${Arvostelu.lisayspaiva}"/>
                    </c:forEach>
                </TD>
                <TD> <c:forEach var="Arvostelu" items="${arv}">
                        <div class="Arvostelu"></div>
                        <c:out value="${Arvostelu.tunnus}"/>
                    </c:forEach>
                </TD>
            </tr>
        </thead>
    </table>
</body>
</html>
