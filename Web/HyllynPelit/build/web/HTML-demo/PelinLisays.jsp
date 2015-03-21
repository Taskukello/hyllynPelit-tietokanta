

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/bootstrap.css" rel="stylesheet">
        <link href="../css/bootstrap-theme.css" rel="stylesheet">
        <link href="../css/main.css" rel="stylesheet">
        <title>Lisää peli</title>
    </head>
    <body>
        <h1>Lisää uusi peli</h1>
        <ul class="nav nav-tabs">
            <li><a href="../Etusivu.jsp"> Etusivu </a></li>
            <li> <a href="../HTML-demo/Pelit.jsp">Pelit</a></li>
            <li> <a href="../HTML-demo/Arvostelut.jsp">Arvostelut</a></li>
            <li><a href="../HTML-demo/Kommentit.jsp">Kommentit</a></li> 
        </ul>
        <div class="container" style="float: left;">
            <form class="form-horizonal" role="form" action="Pelit.jsp" method="POST">
                <div class="form-group">
                    <label for="inputGameName" class="col-md-2 control-label">Pelin Nimi</label>
                    <div class="col-md-10">
                        <input type="Pelin nimi" class="form-control" id="inputGameName" name="Pelin nimi" 
                               placeholder="Pelin nimi">
                    </div></div>



                <div class="form-group">

                    <label for="inputGameYear" class="col-md-2 control-label">julkaisuvuosi</label>
                    <div class="col-md-10">
                        <input type="Pelin nimi" class="form-control" id="inputGameYear" name="Pelin julkaisuvuosi" 
                               placeholder="Pelin julkaisuvuosi">
                    </div>

                </div>
                <div class="form-group">

                    <label for="inputGametekija" class="col-md-2 control-label">Pelin tekijä</label>
                    <div class="col-md-10">
                        <input type="Pelin nimi" class="form-control" id="inputGametekija" name="Pelin tekijä" 
                               placeholder="Pelin tekijä">
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
