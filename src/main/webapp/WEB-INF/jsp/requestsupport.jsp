<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ page import="support.misc.SupportGlobals" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
  <title><fmt:message key="title"/></title>
  <style>
    .error { color: red; }
  </style>  
</head>
<body>
<h1><fmt:message key="form.heading"/></h1>
<form:form method="post" commandName="requestSupport">
  <table width="95%" bgcolor="f8f8ff" border="0" cellspacing="0" cellpadding="5">
    <tr>
      <td align="right" width="20%">Name:</td>
      <td width="20%">
        <form:input path="<%= SupportGlobals.FIELDNAME_NAME %>"
        	maxlength="<%= Integer.toString(SupportGlobals.MAX_NAME_CHARS) %>" />
      </td>
      <td width="60%">
        <form:errors path="<%= SupportGlobals.FIELDNAME_NAME %>" cssClass="error"/>
      </td>
    </tr>
    <tr>
      <td align="right" width="20%">Email:</td>
      <td width="20%">
        <form:input path="<%= SupportGlobals.FIELDNAME_EMAIL %>"
        	maxlength="<%= Integer.toString(SupportGlobals.MAX_EMAIL_CHARS) %>" />
      </td>
      <td width="60%">
        <form:errors path="<%= SupportGlobals.FIELDNAME_EMAIL %>" cssClass="error"/>
      </td>
    </tr>
    <tr>
      <td align="right" width="20%">Order Number:</td>
      <td width="20%">
        <form:input path="<%= SupportGlobals.FIELDNAME_ORDERNUMBER %>"
        	maxlength="<%= Integer.toString(SupportGlobals.MAX_ORDERNUMBER_CHARS) %>" />
      </td>
      <td width="60%">
        <form:errors path="<%= SupportGlobals.FIELDNAME_ORDERNUMBER %>" cssClass="error"/>
      </td>
    </tr>
     <tr>
      <td align="right" width="20%">Issue Description:</td>
      <td width="20%">
        <form:textarea path="<%= SupportGlobals.FIELDNAME_ISSUEDESC %>"
              rows="25" cols="60" />
      </td>
      <td width="60%">
        <form:errors path="<%= SupportGlobals.FIELDNAME_ISSUEDESC %>" cssClass="error" />
      </td>
    </tr>
  </table> 
  <br>
  <input type="submit" align="center" value="Execute">
</form:form>
<a href="<c:url value="homepage.htm"/>">Home</a>
</body>
</html>