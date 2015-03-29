
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

        <h6>Pelejä yhteensä: 0</h6>
        <div>
            <c:if test="${fn:contains(KirjautumisTilanne, 'Et ole kirjautunut sisään')}">
                <a class="btn btn-default" href="ApuKirjaus.jsp" role="button" style="float: right;">Muokkaa</a>  
                <a class="btn btn-default" href="ApuKirjaus.jsp" role="button" style="float: right;">Kommentti</a>
                <a class="btn btn-default" href="ApuKirjaus.jsp" role="button" style="float: right;">Lisää peli</a>
            </c:if>
            <c:if test="${fn:contains(KirjautumisTilanne, 'Kirjautunut sisään käyttäjällä: ')}">
                <a class="btn btn-default" href="${pageContext.request.contextPath}/PelinMuokkaus" role="button" style="float: right;">Muokkaa</a>  
                <a class="btn btn-default" href="${pageContext.request.contextPath}/Kommentti" role="button" style="float: right;">Kommentti</a>
                <a class="btn btn-default" href="${pageContext.request.contextPath}/PelinLisays" role="button" style="float: right;">Lisää peli</a>
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
            </thead>
        </table>
    </body>
</html>
