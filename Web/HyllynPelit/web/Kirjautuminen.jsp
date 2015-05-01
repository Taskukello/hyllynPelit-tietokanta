
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
        <t:virheviesti pageTitle="Kirjautuminen">

        </t:virheviesti>



        <title>Kirjautuminen</title>


    </head>
    <body>

        <h1>Kirjaudu sisään</h1>

        <div class="container">
            <form class="form-horizonal" role="form" action="Login" method="POST">
                <div class="form-group">
                    <label for="Nimimerkki" class="col-md-2 control-label">Käyttäjätunnus: </label>
                    <div class="col-md-10">
                        <input type="text" class="form-control" id="inputGameN" name="Kayttajatunnus" 
                               placeholder="Käyttäjätunnus">
                    </div>
                </div>
                <div class="form-group">

                    <label for="Salasana" class="col-md-2 control-label">Salasana: </label>
                    <div class="col-md-10">
                        <input type="password" class="form-control" id="inputGameN" name="Salasana" 
                               placeholder="Salasana">
                    </div>
                </div>
                <div class="form-group" style="float: right">
                    <div class="col-md-offset-2 col-md-10">
                        <input type="hidden" name="lahde" value="${lahde}">
                        <button type="submit" class="btn btn-default">Kirjaudu</button>

                        <a class="btn btn-default" href="${pageContext.request.contextPath}/Etusivu" role="button" >peruuta</a>
                    </div>


                </div>
            </form>
        </div>

    </body>
</html>
