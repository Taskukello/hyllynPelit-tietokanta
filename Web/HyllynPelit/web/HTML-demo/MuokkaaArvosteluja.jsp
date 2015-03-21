

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/bootstrap.css" rel="stylesheet">
        <link href="../css/bootstrap-theme.css" rel="stylesheet">
        <link href="../css/main.css" rel="stylesheet">
        <title>Muokkaa arvostelua</title>
    </head>
    <body>
        <h1>Muokkaa arvostelua</h1>
        <h1>Lisää Arvostelu</h1>
        <ul class="nav nav-tabs">
            <li><a href="../Etusivu.jsp"> Etusivu </a></li>
            <li> <a href="../HTML-demo/Pelit.jsp">Pelit</a></li>
            <li> <a href="../HTML-demo/Arvostelut.jsp">Arvostelut</a></li>
             <li><a href="../HTML-demo/Kommentit.jsp">Kommentit</a></li> 
        </ul>
        <h2> Pelin nimi: Mass Effect</h2>
        <div class="container" style="float: left;">
            <form class="form-horizonal" role="form" action="Arvostelut.jsp" method="POST">             
                <div class="form-group">
                    <label for="inputGamescore" class="col-md-2 control-label">Arviointi</label>
                    <select>
                        <option value="1">1.</option>
                        <option value="2">2.</option>
                        <option value="3">3.</option>
                        <option value="4">4.</option>
                        <option value="5">6.</option>
                        <option value="7">7.</option>
                        <option value="8">8.</option>
                        <option value="9">9.</option>
                        <option value="10">10.</option>

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
