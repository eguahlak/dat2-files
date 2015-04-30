<%@tag description="put the tag description here" pageEncoding="UTF-8" %>
<%@attribute name="bean" required="true" type="java.lang.String" %>
<%@attribute name="name" required="true" type="java.lang.String" %>
${bean} -- ${name}

<jsp:useBean id="xxx" class="dto.PersonDetail" scope="request" />