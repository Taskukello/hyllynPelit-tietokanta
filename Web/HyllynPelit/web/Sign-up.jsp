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
        <c:if test="${virheet != null}">
        <div class="alert alert-danger">${virheet}
        </div>
    </c:if>
    <title>Sign-up</title>
    <form class="form-horizonal" role="form" action="LisaaTunnus" method="POST">
    </head>
    <body>
        <div class="pieniReunus">
            <h1>Rekistöröidy!</h1>
            <div>Huom! Salasana ja tunnus saavat olla maksimissaa 50 merkkiä pitkät!</div>
        </div>
        <br>
        <br>
        <br>
        <div class="container">

            <div class="form-group">
                <label for="Nimimerkki" class="col-md-2 control-label">Käyttäjätunnus: </label>
                <div class="col-md-10">
                    <input type="text" class="form-control" id="inputGameN" name="Tunnus" 
                           placeholder="Käyttäjätunnus">
                </div>
            </div>
            <div class="form-group">

                <label for="Salasana" class="col-md-2 control-label">Salasana: </label>
                <div class="col-md-10">
                    <input type="password" class="form-control" id="inputGameN" name="salasana" 
                           placeholder="Salasana">
                </div>
            </div>
            <div class="form-group" style="float: right">
                <div class="col-md-offset-2 col-md-10">
                    <button type="submit" class="btn btn-default">Rekistöröidy!</button>

                    <a class="btn btn-default" href="${pageContext.request.contextPath}/Etusivu" role="button" >Peruuta</a>
                </div>

            </div>
</form>
</div>

</body>
</html>