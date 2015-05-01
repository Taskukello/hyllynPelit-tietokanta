
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

        <title>Lisaa Kommentti</title>
    </head>
    <body>
        <div class="pieniReunus">
            <h1>Lisää Kommentti peliin: ${Nimi}</h1>
        </div>
        <ul class="nav nav-tabs">
            <li><a href="${pageContext.request.contextPath}/Etusivu"> Etusivu </a></li>
            <li> <a href="${pageContext.request.contextPath}/Pelit">Pelit</a></li>
            <li> <a href="${pageContext.request.contextPath}/Arvostelut">Arvostelut</a></li>
            <li><a href="${pageContext.request.contextPath}/Kommentit">Kommentit</a></li>
        </ul>

        <div class="container" style="float: left;">
            <form class="form-horizonal" role="form" action="LisaaKommentti" method="POST">

                <div class="form-group">
                    <input type="hidden"  name="PelinNimi" value="${Nimi}"> 


                </div>

                <div class="form-group">
                    <label>Kommentti: (max 500 merkkiä)</label>
                    <br>
                    <textarea name="kommentti" cols="30" rows="5" ></textarea>
                    <br>



                </div>
                <div class="form-group"></div>
                <div class="col-md-offset-2 col-md-10">
                    <button type="submit" class="btn btn-default">Hyväksy</button>
                </div>
            </form>
        </div>

    </body>
</html>