

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
                <input type="hidden" name="lahde" value="Pelit"/>
                <button type="submit" class="btn btn-default"  style="float: right">Kirjaudu sisään</button>
            </form>
        </c:if>
        <c:if test="${fn:contains(KirjautumisTilanne, 'Kirjautunut sisään käyttäjällä: ')}">
            <form action="KirjauduUlos" method="POST">
                <button type="submit" class="btn btn-default"  style="float: right">Kirjaudu Ulos</button>
            </form>
        </c:if>    
        <t:kirjautunut pageTitle="Pelit">

        </t:kirjautunut>

        <title>Pelit</title>
    </head>
    <body>
        <h1>Pelit</h1>
</div>
<br>

<div class="container" style="float: right">
    <form class="form-horizonal" role="form" action="HakuToiminto" method="POST">
        <div class="input-group">
            <input name="hakuSana" type="text" class="form-control" placeholder="Pelin nimi/ tekijä">
            <span class="input-group-btn">
                <button type="submit" class="btn btn-default" type="button">hae!</button>
            </span>
        </div>
    </form>
</div>


<ul class="nav nav-tabs">
    <li><a href="${pageContext.request.contextPath}/Etusivu"> Etusivu </a></li>
    <li class="active"><a>Pelit</a></li>
    <li> <a href="${pageContext.request.contextPath}/Arvostelut">Arvostelut</a></li>
    <li><a href="${pageContext.request.contextPath}/Kommentit">Kommentit</a></li> 
</ul>
<div>

</div>
<c:if test="${ilmoitus != null}">
    <div class="alert alert-info">${ilmoitus}</div>
</c:if>
<div class="pieniReunus">
    <h6>Pelejä yhteensä: <c:out value="${pelienMaara}"/></h6>
</div>
<div>
    <c:if test="${fn:contains(KirjautumisTilanne, 'Et ole kirjautunut sisään')}">
        <form class="form-horizonal" style="float: right" role="form" action="ApuKirjaus" method="POST">
            <input class="form-group" type="hidden"  name="lahde" value="Pelit">
            <button type="submit"  class="btn btn-default">Lisää peli</button>
        </form>     
    </c:if>
    <c:if test="${fn:contains(KirjautumisTilanne, 'Kirjautunut sisään käyttäjällä: ')}">
        <a class="btn btn-default" href="${pageContext.request.contextPath}/PelinLisaysLook" role="button" style="float: right;">Lisää peli</a>

    </c:if>
</div>


<table class="table table-bordered">
    <thead>
        <tr>
            <th>Nimi</th>
            <th>Julkaisuvuosi</th>
            <th>Tekijä</th>
            <th>Milloin lisätty</th>
            <th>PeliAlusta</th>
            <th>Arvosteluiden keskiarvo</th>
        </tr>
        <tr>
            <TD> <c:forEach var="Peli" items="${pelit}">

                    <div class="Peli">
                        <c:if test="${fn:contains(KirjautumisTilanne, 'Et ole kirjautunut sisään')}">
                            <form class="form-horizonal" role="form" action="ApuKirjaus" method="POST">
                                <input class="form-group" type="hidden"  name="lahde" value="Pelit">
                                <button type="submit"  class="btn btn-link">${Peli.peli}</button>
                            </form>

                        </c:if>
                        <c:if test="${fn:contains(KirjautumisTilanne, 'Kirjautunut sisään käyttäjällä: ')}">
                            <form class="form-horizonal" role="form" action="Kommentti" method="POST">        
                                <input class="form-group" type="hidden"  name="pelinNimi" value="${Peli.peli}">
                                <button type="submit"  class="btn btn-link">${Peli.peli}</button>
                            </form>

                        </c:if> 
                    </div>

                </c:forEach>
            </TD>
            <TD style="line-height: 34px;">
                <c:forEach var="Peli" items="${pelit}">
                    <div class="Peli"></div>

                    <c:out value="${Peli.vuosi}"/>

                </c:forEach>
            </TD>
            <TD style="line-height: 34px;"> <c:forEach var="Peli" items="${pelit}">
                    <div class="Peli"></div>
                    <c:out value="${Peli.tekija}"/>
                </c:forEach>
            </TD>
            <TD style="line-height: 34px;"> <c:forEach var="Peli" items="${pelit}">
                    <div class="Peli"></div>
                    <c:out value="${Peli.lisays}"/>
                </c:forEach>
            </TD>
            <TD style="line-height: 34px;"> <c:forEach var="Peli" items="${pelit}">
                    <div class="Peli"></div>
                    <c:out value="${Peli.alusta}"/>
                </c:forEach>
            </TD>
            <TD style="line-height: 34px;"> <c:forEach var="Peli" items="${pelit}">
                    <div class="Peli"></div>
                    <c:out value="${Peli.keskiarvo}"/>
                </c:forEach>
            </TD>
        </tr>
    </thead>
</table>
</body>
</html>
