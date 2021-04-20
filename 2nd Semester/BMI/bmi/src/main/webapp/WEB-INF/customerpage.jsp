<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Demo Page for Customer Roles
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>
        <p>Let's calculate your BMI!</p>
        <p>Visit the <a href="${pageContext.request.contextPath}">homepage</a> to get started!</p>
        <p>Click <a href="${pageContext.request.contextPath}/fc/mybmientries">here</a> to view your previous BMI calculations.</p>
    </jsp:body>

</t:genericpage>

