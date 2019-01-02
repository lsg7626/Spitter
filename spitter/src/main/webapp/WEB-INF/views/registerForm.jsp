<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" %>
<html>
  <head>
    <title>Spitter</title>
    <link rel="stylesheet" type="text/css" 
          href="<c:url value="/resources/style.css" />" >
  </head>
  <body>
    <h1>Register</h1>

    <%-- <sf:form method="POST" commandName="spitter">
      First Name: <sf:input path="firstName" /><sf:errors path="firstName" /><br/>
      Last Name: <sf:input path="lastName" /><sf:errors path="lastName" /><br/>
      Username: <sf:input path="username" /><sf:errors path="username" /><br/>
      Password: <sf:password path="password" /><sf:errors path="password" /><br/>
      <input type="submit" value="Register" />
    </sf:form> --%>
    <sf:form method="POST" commandName="spitter">
    <sf:errors path="*" element="div" cssClass="errors" />
      <sf:label path="firstName" cssErrorClass="error">First Name</sf:label>:
      <sf:input path="firstName" cssErrorClass="error" /><br>
      <sf:label path="lastName" cssErrorClass="error">last Name</sf:label>:
      <sf:input path="lastName" cssErrorClass="error" /><br>
      <sf:label path="username" cssErrorClass="error">username</sf:label>:
      <sf:input path="username" cssErrorClass="error" /><br>
      <sf:label path="password" cssErrorClass="error">password</sf:label>:
      <sf:input path="password" cssErrorClass="error" /><br>
      <input type="submit" value="Register" />
    </sf:form>
  </body>
</html>
