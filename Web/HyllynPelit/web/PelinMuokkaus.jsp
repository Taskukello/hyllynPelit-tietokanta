

<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/bootstrap-theme.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <title>Muokkaa pelin tietoja</title>
    </head>

    <body>
        <h1>Muokkaa</h1>
        <ul class="nav nav-tabs">
            <li><a href="${pageContext.request.contextPath}/Etusivu"> Etusivu </a></li>
            <li> <a href="${pageContext.request.contextPath}/Pelit">Pelit</a></li>
            <li> <a href="${pageContext.request.contextPath}/Arvostelut">Arvostelut</a></li>
             <li><a href="${pageContext.request.contextPath}/Kommentit">Kommentit</a></li> 
        </ul>
        <h6 style="float: right;" >alkuperäinen lisäyspäivä: DD:MM:YYYY </h6>
        <div class="container" style="float: left;">
            <form class="form-horizonal" role="form" action="Pelit.jsp" method="POST">
                <div class="form-group">
                    <label for="inputGameName" class="col-md-2 control-label">Pelin Nimi</label>
                    <div class="col-md-10">
                        <input type="Pelin nimi" class="form-control" id="inputGameName" name="Pelin nimi" 
                               placeholder="Peli Valitaan">
                    </div></div>



                <div class="form-group">

                    <label for="inputGameYear" class="col-md-2 control-label">julkaisuvuosi</label>
                    <div class="col-md-10">
                        <input type="Pelin nimi" class="form-control" id="inputGameYear" name="Pelin julkaisuvuosi" 
                               placeholder="Ennen muokkausta">
                    </div>

                </div>
                <div class="form-group">

                    <label for="inputGametekija" class="col-md-2 control-label">Pelin tekijä</label>
                    <div class="col-md-10">
                        <input type="Pelin nimi" class="form-control" id="inputGametekija" name="Pelin tekijä" 
                               placeholder="Eli ei toimi Ilman tietokanta">
                    </div>

                </div>
                <div class="form-group">
                    <label for="inputGametekija" class="col-md-2 control-label">Pelialusta</label>
                    <select>
                        <option value="Playstation 3">Playstation 3</option>
                        <option value="Tietokone">Tietokone</option>
                        <option value="Wii">VW</option>
                    </select>
                </div>
                <div class="form-group" style="float: right"></div>
                <div class="col-md-offset-2 col-md-10">
                    <button type="submit" class="btn btn-default">Hyväksy</button>
                </div>
            </form>
        </div>
    </body>
</html>
