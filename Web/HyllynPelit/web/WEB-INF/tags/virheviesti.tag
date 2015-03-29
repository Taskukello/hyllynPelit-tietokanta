

<%@tag description="Linkkien automaattinen lisäys" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<link href="../css/bootstrap.css" rel="stylesheet">
<link href="../css/bootstrap-theme.css" rel="stylesheet">
<link href="../css/main.css" rel="stylesheet">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="pageTitle"%>
<!DOCTYPE html>
<html>
    <head>
        <c:if test="${virheViesti != null}">
        <div class="alert alert-danger">Virhe! ${virheViesti}</div>
    </c:if>
</head>
</html>
