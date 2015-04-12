<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/bootstrap-theme.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <c:out value="${muuttuja}"/>
        <c:if test="${virheet != null}">
        <div class="alert alert-danger">${virheet}
        </div>
    </c:if>
    <title>Lisää peli</title>

</head>
<body>
    <h1>Lisää uusi peli</h1>
    <ul class="nav nav-tabs">
        <li><a href="${pageContext.request.contextPath}/Etusivu"> Etusivu </a></li>
        <li> <a href="${pageContext.request.contextPath}/Pelit">Pelit</a></li>
        <li> <a href="${pageContext.request.contextPath}/Arvostelut">Arvostelut</a></li>
        <li><a href="${pageContext.request.contextPath}/Kommentit">Kommentit</a></li> 
    </ul>

    <div class="container" style="float: left;">
        <form class="form-horizonal" role="form" action="PelinLisays" method="POST">

            <div class="form-group">
                <label for="inputGameName" class="col-md-2 control-label">Pelin Nimi</label>
                <div class="col-md-10">
                    <input type="Pelin nimi" class="form-control" id="inputGameName" name="PelinNimi" 
                           placeholder="PelinNimi">
                </div>
            </div>

            <div class="form-group">

                <label for="inputGametekija" class="col-md-2 control-label">Pelin tekijä</label>
                <div class="col-md-10">
                    <input type="Pelin Tekijä" class="form-control" id="inputGametekija" name="Tekija" 
                           placeholder="Tekijä">
                </div>

            </div>



            <div class="form-group">

                <label for="inputGameYear" class="col-md-2 control-label">julkaisuvuosi</label>
                <select name="Julkaisuvuosi">
                    <div class="col-md-10">

                        <option value="2015">2015</option>
                        <option value="2014">2014</option>
                        <option value="2013">2013</option>
                        <option value="2012">2012</option>
                        <option value="2011">2011</option>
                        <option value="2010">2010</option>
                        <option value="2009">2009</option>
                        <option value="2008">2008</option>
                        <option value="2007">2007</option>
                        <option value="2006">2006</option>
                        <option value="2005">2005</option>
                        <option value="2004">2004</option>
                        <option value="2003">2003</option>
                        <option value="2002">2002</option>
                        <option value="2001">2001</option>
                        <option value="2000">2000</option>
                        <option value="1999">1999</option>
                        <option value="1998">1998</option>
                        <option value="1997">1997</option>
                        <option value="1996">1996</option>
                        <option value="1995">1995</option>
                        <option value="1994">1994</option>
                        <option value="1993">1993</option>
                        <option value="1992">1992</option>

                </select>

            </div>



            <div class="form-group">
                <label for="inputGamePlatform" class="col-md-2 control-label">Pelialusta</label>
                <select name="Alusta">
                    <option value="Playstation 3">Playstation 3</option>
                    <option value="Tietokone">Tietokone</option>
                    <option value="Wii">Wii</option>

                </select>

            </div>
            <div class="form-group" ></div>
            <div class="col-md-offset-2 col-md-10">
                <button type="submit" class="btn btn-default">Hyväksy</button>
            </div>
        </form>
    </div>


</body>
</html>
