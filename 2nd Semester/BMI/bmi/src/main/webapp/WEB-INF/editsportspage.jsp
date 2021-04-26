<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Edit Sports-types
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <h1>Hello ${sessionScope.email}</h1>
        <h4>Here you can edit and update sport-types:</h4>

        <form action="${pageContext.request.contextPath}/fc/managesports" method="post">
            <input type="hidden" name="sports_id" value="${requestScope.sportItem.sport_id}"/>

            <div class="input-group input-group-sm mb-3">
                <td><input type="text" name="name" value="${requestScope.sportItem.name}"/></td>
                <td><button class="btn btn-secondary btn-sm" type="submit" name="update">Update</button></td>
            </div>

            <br/>

            <c:if test="${not empty requestScope.error}">
                <p style="color:red;font-size: large">${requestScope.error}</p>
            </c:if>
        </form>

    </jsp:body>
</t:genericpage>
