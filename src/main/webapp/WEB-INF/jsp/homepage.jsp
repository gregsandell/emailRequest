<%@ include file="/WEB-INF/jsp/include.jsp" %>
<html>
  <head><title><fmt:message key="title"/></title></head>
  <body>
    <h1><fmt:message key="heading"/></h1>
    <p><c:out value="${model.mesg}"/></p>
    <br>
    <a href="<c:url value="requestsupport.htm"/>">Request Support</a>
    <br>
  </body>
</html>