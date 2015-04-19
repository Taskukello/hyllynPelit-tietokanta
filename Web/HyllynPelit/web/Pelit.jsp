
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

    <div class="row" >

        <div class="col-lg-6" style="float: right">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Pelin nimi/ julkaisuvuosi/ tekijä">
                <span class="input-group-btn">
                    <button class="btn btn-default" type="button">hae!</button>
                </span>
            </div><!-- /input-group -->
        </div><!-- /.col-lg-6 -->
    </div><!-- /.row -->


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
    <h6>Pelejä yhteensä: <c:out value="${pelienMaara}"/></h6>
    <div>
        <c:if test="${fn:contains(KirjautumisTilanne, 'Et ole kirjautunut sisään')}">
            <form class="form-horizonal" style="float: right" role="form" action="ApuKirjaus" method="POST">
                <input class="form-group" type="hidden"  name="lahde" value="Pelit">
                <button type="submit"  class="btn btn-default">Lisää peli</button>
            </form>     
        </c:if>
        <c:if test="${fn:contains(KirjautumisTilanne, 'Kirjautunut sisään käyttäjällä: ')}">
            <a class="btn btn-default" href="PelinLisays.jsp" role="button" style="float: right;">Lisää peli</a>

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
                        <form class="form-horizonal" role="form" action="Kommentti" method="POST">                                 
                            <div class="Peli">
                                <c:if test="${fn:contains(KirjautumisTilanne, 'Et ole kirjautunut sisään')}">
                                    <a style="line-height: 34px" href="#">${Peli.peli}</a>
                                </c:if>
                                <c:if test="${fn:contains(KirjautumisTilanne, 'Kirjautunut sisään käyttäjällä: ')}">

                                    <input class="form-group" type="hidden"  name="pelinNimi" value="${Peli.peli}">
                                    <button type="submit"  class="btn btn-link">${Peli.peli}</button>


                                </c:if> 
                            </div>
                        </form>
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
