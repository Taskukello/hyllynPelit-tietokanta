

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<%@attribute name="pageTitle"%>

<c:if test="${fn:contains(KirjautumisTilanne, 'Et ole kirjautunut sisään')}">
    <a class="btn btn-default" href="Kirjautuminen.jsp" role="button" style="float: right;" >Kirjaudu sisään</a>
</c:if>
<c:if test="${fn:contains(KirjautumisTilanne, 'Kirjautunut sisään käyttäjällä: ')}">
    <form action="KirjauduUlos" method="POST">
        <button type="submit" class="btn btn-default" value="${pageTitle}" style="float: right">Kirjaudu Ulos</button>
    </form>
</c:if>    