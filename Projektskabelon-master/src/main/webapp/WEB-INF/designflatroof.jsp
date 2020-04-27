<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/header.inc" %>

<h1>Fladt tag design</h1>
<!--TODO fyld dropdown menu med data from DB, skriv former til alle de atributter som skal tastes for at kunne designe en fladt tag-->

<br>
<form name="designflatroof" action="FrontController" method="POST">
    <input type="hidden" name="target" value="designflatroof">
    <label>Vælg hældningsgrad:</label>
    <select name="tilt" class="form-control" >
        <c:forEach var="i" begin="2" end="10">
            <option value=${i}>${i}</option>
        </c:forEach>
    </select>


</form>
<%@include file="../includes/footer.inc"%>
