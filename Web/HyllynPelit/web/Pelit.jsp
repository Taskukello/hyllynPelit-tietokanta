
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
        <t:kirjauduNappi pageTitle="Pelit">

        </t:kirjauduNappi>
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
                <a class="btn btn-default" href="ApuKirjaus.jsp" role="button" style="float: right;">Kommentti</a>
                <a class="btn btn-default" href="ApuKirjaus.jsp" role="button" style="float: right;">Lisää peli</a>
                <a class="btn btn-default" href="ApuKirjaus.jsp" role="button" style="float: right;">Muokkaa</a>  
            </c:if>
            <c:if test="${fn:contains(KirjautumisTilanne, 'Kirjautunut sisään käyttäjällä: ')}">

                <a class="btn btn-default" href="${pageContext.request.contextPath}/Kommentti" role="button" style="float: right;">Kommentti</a>
                <a class="btn btn-default" href="PelinLisays.jsp" role="button" style="float: right;">Lisää peli</a>

                <div class="form-group" style="float: right; ">
                    <form class="form-horizonal" role="form" action="PelitValinnanUudelleenOhjaus" method="POST">
                        <select name="muokattavanNimi">
                            <c:forEach var="Peli" items="${pelit}">
                                <option value="${Peli.peli}">${Peli.peli}</option>
                            </c:forEach>                            
                        </select>
                        <button type="submit" class="btn btn-default" name="action" value="muokkaa">Muokkaa</button>
                        <button type="submit" class="btn btn-default" name="action" value="Kommentti">Lisää Kommentti</button>
                        <c:if test="${fn:contains(oikeus, 'Admin')}">
                            <button type="submit" class="btn btn-default" name="action" value="Poista">Poista</button>
                        </c:if>
                    </form>
                </div>
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
                    <th>Arvosana</th>
                </tr>
                <tr>
                    <TD> <c:forEach var="Peli" items="${pelit}">
                            <div class="Peli"></div>
                            <c:out value="${Peli.peli}"/>
                        </c:forEach>
                    </TD>
                    <TD> <c:forEach var="Peli" items="${pelit}">
                            <div class="Peli"></div>
                            <c:out value="${Peli.vuosi}"/>
                        </c:forEach>
                    </TD>
                    <TD> <c:forEach var="Peli" items="${pelit}">
                            <div class="Peli"></div>
                            <c:out value="${Peli.tekija}"/>
                        </c:forEach>
                    </TD>
                    <TD> <c:forEach var="Peli" items="${pelit}">
                            <div class="Peli"></div>
                            <c:out value="${Peli.lisays}"/>
                        </c:forEach>
                    </TD>
                    <TD> <c:forEach var="Peli" items="${pelit}">
                            <div class="Peli"></div>
                            <c:out value="${Peli.alusta}"/>
                        </c:forEach>
                    </TD>
                </tr>
            </thead>
        </table>
    </body>
</html>
