<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<body id="SearchDocumentForm" bgcolor="#ffffcc">
<h2>Search Document</h2>
<p>Here is your Search Result</p>
<form id="SearchDocumentForm">

 <TABLE style="background-color: #ECE5B6;" WIDTH="50%">
                <tr width="100%">
                    <td >Search Result</td>
                      <td>  <c:forEach items="${responseMsg}" var="reponseString">
                               <br/> <c:out value="${reponseString}"/>
                        </c:forEach>
                        </td>

                </tr>
                <tr>
                    <td width="20%">Elapsed Time</td>
                     <td ><c:out value="${elapsedTime}"/> seconds</td>
                </tr>
				<tr><td></td><td></td>
 </TABLE>
</form>
</body>

</html>