

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
        <t:kirjautunut pageTitle="Kommentti">

        </t:kirjautunut>
        <title>Pelin tiedot ja muokkaus</title>
    </head>
    <body>
        <h1>Pelin tarkemmat tiedot ja muokkaus</h1>
        <H3>Pelin nimi: ${pelinNimi}</H3>
        <ul class="nav nav-tabs">
            <li><a href="${pageContext.request.contextPath}/Etusivu"> Etusivu </a></li>
            <li><a href="${pageContext.request.contextPath}/Pelit">Pelit</a></li>
            <li> <a href="${pageContext.request.contextPath}/Arvostelut">Arvostelut</a></li>
            <li><a href="${pageContext.request.contextPath}/Kommentit">Kommentit</a></li> 
        </ul>

        <div class="reunus">   <%-- itse tehty reunus keskittämään sivun sisältöä --%>
            <h3>julkaisia: ${pelinjulkaisia}</h3>
            <h3>julkaisuvuosi: ${pelinJvuosi}</h3>
            <c:if test="${keskiarvo < 1}">
                <h3> pelillä ei ole vielä yhtäkään arvostelua! </h3>
            </c:if>
            <c:if test="${keskiarvo > 0}">
                <h3>arvosteluiden keskiarvo: ${keskiarvo}</h3>
                <h3>arvosteluiden määrä: ${arvosteluita}</h3>
            </c:if>
            <c:forEach var="Kommentti" items="${kommentit}">

                <div class="Kommentti"></div>
                <h3>Kommentti:</h3>
                <c:out value="${Kommentti.kommentti}"/>
                <div>
                    <c:out value="Kirjoittanut: ${Kommentti.tunnus}"/>
                </div>
            </c:forEach>
            <div class="form-group" style="float: right; ">
                <form class="form-horizonal" role="form" action="PelitValinnanUudelleenOhjaus" method="POST">
                    <input type="hidden" name="muokattavanNimi" value="${pelinNimi}"/>
                    <c:if test="${onkoKommentti < 1}">
                        <button type="submit" class="btn btn-default" name="action" value="Kommentti">Lisää Kommentti</button>
                    </c:if>
                    <c:if test="${onkoKommentti > 0}">
                        <button type="submit" class="btn btn-default" name="action" value="KommentinMuokkaus">Muokkaa Kommenttiasi</button>
                    </c:if>
                    <c:if test="${fn:contains(oikeus, 'Admin')}">
                        <button type="submit" class="btn btn-default" name="action" value="Poista">Poista peli</button>
                        <div> HUOM! Poistaessasi Pelin kaikki kyseiseen peliin viittaava tieto</div>
                        <div> (kommentit, arvostelut) katoaa myös! </div>
                    </c:if>
                    <button type="submit" class="btn btn-default" name="action" value="muokkaa">Muokkaa Peliä</button>
                </form>
            </div>

            <div class="form-group">
                <form class="form-horizonal" role="form" action="Kommentti" method="POST">
                    <c:if test="${sivu > 1}">
                        <button type="submit" class="btn btn-default" name="action" value="Edellinen">Edellinen</button>
                    </c:if>
                    <c:if test="${sivu < sivuja}">
                        <button type="submit" class="btn btn-default" name="action" value="Seuraava">Seuraava</button>
                    </c:if>

                </form>


            </div>
        </div>
    </body>
</html>
