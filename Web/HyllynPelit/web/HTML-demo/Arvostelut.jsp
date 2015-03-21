<%-- 
    Document   : Arvostelut
    Created on : 20.3.2015, 14:37:41
    Author     : Aki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/bootstrap.css" rel="stylesheet">
        <link href="../css/bootstrap-theme.css" rel="stylesheet">
        <link href="../css/main.css" rel="stylesheet">
        <title>Arvostelut</title>
    </head>
    <body>
        <h1>Arvostelut</h1>
        <div class="row" style="float: right">
   
            <div class="col-lg-6" style="float: right">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Pelin nimi">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button">hae!</button>
                    </span>
                </div><!-- /input-group -->
            </div><!-- /.col-lg-6 -->
        </div><!-- /.row -->
        <ul class="nav nav-tabs">
            <li><a href="../Etusivu.jsp"> Etusivu </a></li>
            <li><a href="../HTML-demo/Pelit.jsp">Pelit</a></li>
            <li class="active"> <a href="../HTML-demo/Arvostelut.jsp">Arvostelut</a></li>
            <li><a href="../HTML-demo/Kommentit.jsp">Kommentit</a></li> 
        </ul>
        <h6>Pelejä yhteensä: 0</h6>
        <a class="btn btn-default" href="../HTML-demo/LisaaArvostelu.jsp" role="button" style="float: right;" >Lisää Arvostelu</a>
        <a class="btn btn-default" href="../HTML-demo/MuokkaaArvosteluja.jsp" role="button" style="float: right;" >Muokkaa</a>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Nimi</th>
                    <th>Julkaisuvuosi</th>
                    <th>Arvostelu</th>
                    <th>Arvostelun lisäyspäivä</th>



                </tr>
            </thead>
        </table>
    </body>
</html>
