
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/header.inc"%>
<h1>Hello, world!</h1>



<form name="showRequests" action="FrontController" method="POST">
    <input type="hidden" name="target" value="showRequests">
    <input type="submit" value="Vis Forespørgelser">
</form>




<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->

<%@include file="../includes/footer.inc"%>