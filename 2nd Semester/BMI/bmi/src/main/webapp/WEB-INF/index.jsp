<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         Home
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>

        <div class="row">
            <div class="col-sm-4"></div>

            <div class="col-sm-4">
                <h2>BMI calculator</h2>

                <form method="post" action="${pageContext.request.contextPath}/fc/bmiresult">
                    <div class="form-group">
                        <label for="height">Height in cm</label>
                        <input id="height" name="height" type="text" class="form-control"/>
                    </div>

                    <div class="form-group">
                        <label for="weight">Weight in kg</label>
                        <input id="weight" name="weight" type="text" class="form-control"/>
                    </div>

                    <br/>

                    <div>
                        <input type="radio" id="male" name="gender" value="male">
                        <label for="male">Male</label>
                        <input type="radio" id="female" name="gender" value="female">
                        <label for="female">Female</label>
                        <input type="radio" id="nonconformist" name="gender" value="nonconformist">
                        <label for="nonconformist">Nonconformist</label>
                    </div>

                    <br/>

                    <div>
                        <label for="sport">Choose your primary sport:</label>
                        <select name="sport" id="sport">
                            <option value="1">Free-diving</option>
                            <option value="2">Extreme Fishing</option>
                            <option value="3">Golf (really??)</option>
                            <option value="4">4D Chess</option>
                        </select>
                    </div>

                    <br/>

                    <div>
                        <p>Select your hobbies:</p>
                        <input type="checkbox" id="hobby1" name="hobby" value="1">
                        <label for="hobby1">Avalanche Sledding</label><br>
                        <input type="checkbox" id="hobby2" name="hobby" value="2">
                        <label for="hobby2">Playing with my 18 cats</label><br>
                        <input type="checkbox" id="hobby3" name="hobby" value="3">
                        <label for="hobby3">Bungee-jumping while knitting</label><br>
                        <input type="checkbox" id="hobby4" name="hobby" value="4">
                        <label for="hobby4">Wondering where my life went so wrong</label><br>
                        <input type="checkbox" id="hobby5" name="hobby" value="5">
                        <label for="hobby5">Building model trains (I'm not a serial killer... yet)</label><br>
                        <input type="checkbox" id="hobby6" name="hobby" value="6">
                        <label for="hobby6">Disassociating in the shower</label><br>
                    </div>

                    <br/>

                    <c:if test="${requestScope.error != null}">
                        <p style="color:red">
                                ${requestScope.error}
                        </p>
                    </c:if>

                    <button type="submit" class="btn btn-primary">Calculate BMI</button>
                </form>
            </div>

            <div class="col-sm-4"></div>
        </div>

        <div>
            <c:if test="${sessionScope.role == 'employee' }">
                <p style="font-size: larger">This is what you can do,
                    since your are logged in as an employee</p>
                 <p><a href="fc/employeepage">Employee Page</a>
             </c:if>

             <c:if test="${sessionScope.role == 'customer' }">
                <p style="font-size: larger">This is what you can do, since your
                    are logged in as a customer</p>
                <p><a href="fc/customerpage">Customer Page</a>
            </c:if>

        </div>

    </jsp:body>
</t:genericpage>