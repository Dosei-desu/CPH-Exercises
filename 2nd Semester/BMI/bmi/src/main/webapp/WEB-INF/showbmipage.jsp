<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         List of BMI entries
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>
        This is a list of all BMI entries:

        <table class="table">
            <thead><th>#</th><th>BMI</th><th>Category</th><th>Gender</th><th>Height</th><th>Weight</th><th>Created</th></thead>
            <c:forEach var="bmiEntry" items="${requestScope.bmiEntryList}">
                <tr>
                    <td>${bmiEntry.id}</td>
                    <td>${bmiEntry.bmi}</td>
                    <td>${bmiEntry.category}</td>
                    <td>${bmiEntry.gender}</td>
                    <td>${bmiEntry.height}</td>
                    <td>${bmiEntry.weight}</td>
                    <td>${bmiEntry.created}</td>
                </tr>
            </c:forEach>
        </table>

    </jsp:body>
</t:genericpage>
