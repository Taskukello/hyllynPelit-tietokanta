
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

        <t:kirjautunut pageTitle="Kommentit">

        </t:kirjautunut>
        <title>Kommentit</title>
    </head>
    <body>
        <h1>Kommentit</h1>

        <div class="row" >

            <div class="col-lg-6" style="float: right;">
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
            <li> <a href="${pageContext.request.contextPath}/Arvostelut">Arvostelut</a></li>

            <li class="active"><a>Kommentit</a></li> 
        </ul>
        <h6>Pelejä yhteensä: 0</h6>
        <h6> </h6>
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
