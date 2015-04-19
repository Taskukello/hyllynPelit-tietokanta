

<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>




<!DOCTYPE html>

<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/bootstrap-theme.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <t:kirjautunut pageTitle="Etusivu">

        </t:kirjautunut>

        <title>Etusivu</title>
    </head>
    <body>
        <h1>Etusivu</h1>
        <c:if test="${fn:contains(KirjautumisTilanne, 'Et ole kirjautunut sisään')}">
            <form action="Kirjautuminen" method="POST">
                <input type="hidden" name="lahde" value="Etusivu"/>
                <button type="submit" class="btn btn-default"  style="float: right">Kirjaudu sisään</button>
            </form>
        </c:if>
        <c:if test="${fn:contains(KirjautumisTilanne, 'Kirjautunut sisään käyttäjällä: ')}">
            <form action="KirjauduUlos" method="POST">
                <button type="submit" class="btn btn-default"  style="float: right">Kirjaudu Ulos</button>
            </form>
        </c:if> 
        <ul class="nav nav-tabs">
            <li class="active"><a> Etusivu </a></li>
            <li><a href="${pageContext.request.contextPath}/Pelit">Pelit</a></li>
            <li> <a href="${pageContext.request.contextPath}/Arvostelut">Arvostelut</a></li>
            <li><a href="${pageContext.request.contextPath}/Kommentit">Kommentit</a></li>
        </ul>
        <h3> Tietokannan kuvaus </h3>
        <div>Tähän tulee myöhemmin lyhyt kuvaus tietokannasta.</div>
        <div>Vihdoin kirjautuminen ohjaa oikealle juurisivulle. Käyttäjätunnukset joilla on täydet valtuudet on tällähetkin:.</div>
        <div> tunnus: Admin, salasana: Admin. Normaali tason tunnus on: tunnus: Vaapukkamehu salasana: tomaatti </div>
        <div>Sen lisäksi toiset normaalitunnukset ovat tunnus: aladin, salasana: prinssi</div>
        <div>Pelin Muokkaus ja poistotoiminto (vain admin voi poistaa) on siirretty omalle sivulleen</div>
        <div>Ja niihin pääsee käsiksi painamalla pelin nimeä (jos et ole kirjautunut nimen painallus ei tee vielä mitään)</div>
        <div>Tällä viikolla minun piti saada myös hakutoiminto pystyyn, mutta Sivun korjailu ja parantelu vei odotettua enemmän</div>
        <div>Aikaa. Edellä mainittu pelikohtainen tietosivu nyt myös näyttää pelille kirjoitetut kommentit, ja antaa käyttäjän </div>
        <div> Lisätä uuden kommentin (käyttäjä voi lisätä vain yhden kommentin peliä kohti), ja halutessaan muokkaa tai poistaa</div>
        <div> Sivulle Arvostelu tulee vielä tärkeä muutos jatkossa. nimittäin arvosanan lisäksi lyhyt mielipide pelistä.</div>
        <div> Sen lisäksi. Arvostelut sivun pudotuspalkki josta valitaan peli ei tule muuttumaan! Mielestäni tämä on käyttäjälle</div>
        <div> Parempi ratkaisu kuin Pelit sivulla käytetty tapa, koska Käyttäjä pääsee muokkaamaan vain itse lisäämiään arvosteluja</div>
        <div> En ole myöskään vielä varma lisäänkö arvostelun poistoa Ollenkaan.</div>
        <div> Niinjuu ja ääkköset eivät jostain syystä toimi vielä....?</div>
    </body>
</html>



