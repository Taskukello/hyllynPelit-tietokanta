

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>



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
        <t:kirjauduNappi pageTitle="Etusivu">

        </t:kirjauduNappi>
        <ul class="nav nav-tabs">
            <li class="active"><a> Etusivu </a></li>
            <li><a href="${pageContext.request.contextPath}/Pelit">Pelit</a></li>
            <li> <a href="${pageContext.request.contextPath}/Arvostelut">Arvostelut</a></li>
            <li><a href="${pageContext.request.contextPath}/Kommentit">Kommentit</a></li>
        </ul>
        <h3> Tietokannan kuvaus </h3>
        <div>Tähän tulee myöhemmin lyhyt kuvaus tietokannasta. HUOM! Toistaiseksi miltä tahansa sivulta kirjautuminen tulee uudelleenohjaamaan.</div>
        <div>käyttäjän etusivulle. Tämä tulee muuttumaan. Käyttäjätunnukset joilla on täydet valtuudet on tällähetkin:.</div>
        <div> tunnus: Admin, salasana: Admin. Normaali tason tunnus on: tunnus: Vaapukkamehu salasana: tomaatti </div>
        <div>sivu Apukirjaus myös tekee tällä hetkin saman kuin kuin Kirjautuminen, mutta tämän tulee jatkossa</div>
        <div>muuttumaan. Jatkossa Apukirjaus tulee siirtämään käyttäjän takaisin sivulle josta hän sinne on joutunut</div>
        <div>(eli heti kun keksin miten se tehdään ilman miljoonaa jsp tiedostoa).</div>
        <div> Tällä hetkin Lisäys ominaisuuden ja muokkaus ominaisuuden omaa vain Pelit sivu. Sen lisäksi arvosteluja ja kommentteja voi lisätä. </div>
        <div> Ainoastaan sivulla Pelit on Poisto toiminto, ja sen näkee vain kirjautuneena Admin tunnuksilla! </div>
    </body>
</html>



