<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         BMI Result Page
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${true}" scope="request"/>
    </jsp:attribute>

    <jsp:body>

        <div class="row">
            <div class="col-sm-4"></div>

            <div class="col-sm-4">
                <h2>BMI Result</h2>

                <p>
                    Your height is ${requestScope.height} cm.<br/>
                    Your weight is ${requestScope.weight} kg.
                </p>
                <p>
                    Your BMI is calculated to be: ${requestScope.bmi}<br/>
                </p>
                <p>
                    You are thus considered ${requestScope.category}.<br/>
                </p>
                <p>
                    Gender: ${requestScope.gender}
                </p>
                <p>
                    Sport: ${requestScope.sport_id}
                </p>
                <p>
                    Hobbies:<br/>
                    <c:forEach var="hobbyitem" items="${requestScope.hobbies}">
                        - ${hobbyitem}<br/>
                    </c:forEach>
                </p>
            </div>

            <div class="col-sm-4"></div>

        </div>

    </jsp:body>
</t:genericpage>