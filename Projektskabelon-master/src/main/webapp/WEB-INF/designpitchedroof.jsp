<%@ page import="CarportUtil.Initializer" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/header.inc"%>

<%
// if i'm the first user on this application, then set the pitchedMaterialList. (else the list already exists)
if (request.getServletContext().getAttribute("pitchedMaterialList") == null) {
System.out.println("initializing materiallist");
}
request.getServletContext().setAttribute("pitchedMaterialList", Initializer.getPitchedRoofMateriallist());
%>

<div class="container2">
    <div class="col-md-12">
        <form name="makerequest" action="FrontController" method="post">
            <input type="hidden" name="target" value="makerequest">
            <br>
            <br>
            <h2>Tag med rejsning design</h2>
            <label class="mt-3" for="pitchedroof"> Vælg tagdækning for tag med hældning:</label>
            <select class="form-control mt-3" name="pitchedroof" id="pitchedroof">
                <option selected disabled>Vælg tagdækning</option>
                <c:forEach var="roofMaterial" items="${applicationScope.pitchedMaterialList}">
                    <option value="${roofMaterial.id}">${roofMaterial.name}</option>
                </c:forEach>
            </select>

            <br>
            <a class="mt-3 btn btn-dark" href="FrontController?target=redirect&destination=overlay" role="button">Videre til beklædning</a>
        </form>
        <!-- End of form -->

        <form name="startOver" action="FrontController" method="POST">
            <input type="hidden" name="target" value="newrequest">
            <input class="mt-3 mb-4 btn btn-outline-dark" type="submit" name="newrequest" value="Start forfra">
        </form>
    </div>
</div>

<%@include file="../includes/footer.inc"%>
