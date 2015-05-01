<%@page contentType="text/html" pageEncoding="ISO-8859-1" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/bootstrap-theme.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">

        <title>Muokkaa arvostelua</title>
    </head>
    <body>
        <h1>Muokkaa arvostelua</h1>
        <ul class="nav nav-tabs">
            <li><a href="${pageContext.request.contextPath}/Etusivu"> Etusivu </a></li>
            <li> <a href="${pageContext.request.contextPath}/Pelit">Pelit</a></li>
            <li> <a href="${pageContext.request.contextPath}/Arvostelut">Arvostelut</a></li>
            <li><a href="${pageContext.request.contextPath}/Kommentit">Kommentit</a></li> 
        </ul>
        <h2> Pelin nimi: ${nimi}</h2>
        <div class="container" style="float: left;">

            <form class="form-horizonal" role="form" action="ArvostelunMuokkaus" method="POST">      
                <div class="form-group">
                    <input type="hidden"  name="PelinNimi" value="${nimi}"> 


                </div>
                <div class="form-group">
                    <label>Arvosana</label>
                    <select name="arvosana">

                        <option value="1">1.</option>
                        <option value="2">2.</option>
                        <option value="3">3.</option>
                        <option value="4">4.</option>
                        <option value="5">5.</option>
                        <option value="6">6.</option>
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
