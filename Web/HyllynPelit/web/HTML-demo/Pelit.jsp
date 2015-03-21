

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/bootstrap.css" rel="stylesheet">
        <link href="../css/bootstrap-theme.css" rel="stylesheet">
        <link href="../css/main.css" rel="stylesheet">
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
            <li><a href="../Etusivu.jsp"> Etusivu </a></li>
            <li class="active"><a href="../HTML-demo/Pelit.jsp">Pelit</a></li>
            <li> <a href="../HTML-demo/Arvostelut.jsp">Arvostelut</a></li>
            <li><a href="../HTML-demo/Kommentit.jsp">Kommentit</a></li> 
        </ul>
        <div>
            <a class="btn btn-default" href="../HTML-demo/PelinLisays.jsp" role="button" style="float: right;" >Lisää Peli</a>
            <a class="btn btn-default" href="../HTML-demo/PelinMuokkaus.jsp" role="button" style="float: right;">Muokkaa</a>
            <a class="btn btn-default" href="../HTML-demo/Kommentti.jsp" role="button" style="float: right;">Kommentti</a>
        </div>
        <h6>Pelejä yhteensä: 0</h6>
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
