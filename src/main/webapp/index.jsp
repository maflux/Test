<%-- 
    Document   : index
    Created on : Sep 5, 2017, 7:49:05 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
	<link href="WEB-INF/TableStyle.css" type="text/css" rel="stylesheet">
	<style>
	    <%@include file="WEB-INF/TableStyle.css"%>
	    <%@include file="WEB-INF/SelectStyle.css"%>
	    <%@include file="WEB-INF/ButtonStyle.css"%>
	</style>
    </head>
    <body>
	<form action="Reports" method="POST" >
	    <table align="center">
		<tr>
		    <td>
			Start Date
		    </td>
		    <td>
			<select size="1" name="startMonth">
			    <option selected="true" value="1">Jan</option>
			    <option value="2">Feb</option>
			    <option value="3">Mar</option>
			    <option value="4">Apr</option>
			    <option value="5">May</option>
			    <option value="6">Jun</option>
			    <option value="7">Jul</option>
			    <option value="8">Aug</option>
			    <option value="9">Sep</option>
			    <option value="10">Oct</option>
			    <option value="11">Nov</option>
			    <option value="12">Dec</option>
			</select>
			<select size="1" name="startDay">
			    <option value="1">1</option>
			    <c:forEach begin="1" end="31" var="day" >
				<option value="${day}">${day}</option>
			    </c:forEach>
			</select>
			<select size="1" name="startYear">
			    <option value="2000">2000</option>
			    <c:forEach begin="2000" end="2025" var="year" >
				<option value="${year}">${year}</option>
			    </c:forEach>
			</select>
		    </td>
		</tr>
		<tr>
		    <td>
			End Date
		    </td>
		    <td>
			<select size="1" name="endMonth">
			    <option value="12"></option>
			    <option value="1">Jan</option>
			    <option value="2">Feb</option>
			    <option value="3">Mar</option>
			    <option value="4">Apr</option>
			    <option value="5">May</option>
			    <option value="6">Jun</option>
			    <option value="7">Jul</option>
			    <option value="8">Aug</option>
			    <option value="9">Sep</option>
			    <option value="10">Oct</option>
			    <option value="11">Nov</option>
			    <option selected="true" value="12">Dec</option>
			</select>
			<select size="1" name="endDay">
			    <option value="31">31</option>
			    <c:forEach begin="1" end="31" var="day" >
				<option value="${day}">${day}</option>
			    </c:forEach>
			</select>
			<select size="1" name="endYear">
			    <option value="2025">2025</option>
			    <c:forEach begin="2000" end="2025" var="year" >
				<option value="${year}">${year}</option>
			    </c:forEach>
			</select>

		    </td>
		</tr>
		<tr>
		    <td>
			Perform
		    </td>
		    <td>
			<select size="1" name="performer">
			    <option value="All performed">All Performed</option>
			    <c:forEach items="${applicationScope.listPerformers}" var="performer" >
				<option value="${performer}">${performer}</option>
			    </c:forEach>
			</select>

		    </td>
		</tr>
		<tr>
		    <td>
			Time Prd
		    </td>
		    <td>
			<select size="1" name="timePrd">
			    <option value=""></option>
			    <option value="lastQtr">Last Qtr</option>
			    <option value="lastMonth">Last Month</option>
			    <option value="lastCalendarYear">Last Calendar Year</option>
			    <option value="currentYearToDate">Current Year to Date</option>
			    <option value="currentQtrToDate">Current Qtr to Date</option>
			    <option value="currentMonthToDate">Current Month to Date</option>
			</select>		
		    </td>
		</tr>
		<tr>
		    <td colspan="2">
			<input type="hidden" value="reports" name="cmd"/>
			<input type="submit"/>
		    </td>
		</tr>
	    </table>
	</form>
	<c:if test="${empty requestScope.listReports}">
	    <table align="center">
		<tr>
		    <th>ID</th>
		    <th>Start Date</th>
		    <th>End Date</th>
		    <th>Performer</th>
		    <th>Activity</th>
		</tr>
		<tr align="middle">
		    <td colspan="5">${applicationScope.error}</td>
		</tr>
	    </table>
	</c:if>
	<c:if test="${not empty requestScope.listReports}">

	    <table>
		<tr>
		    <th>ID</th>
		    <th>Start Date</th>
		    <th>End Date</th>
		    <th>Performer</th>
		    <th>Activity</th>
		</tr>

		<c:forEach items="${requestScope.listReports}" var="report">
		    <tr>
			<td>${report.id}</td>
			<td>${report.start}</td>
			<td>${report.end}</td>
			<td>${report.performer}</td>
			<td>${report.activity}</td>
		    </tr>
		</c:forEach>
	    </table>
	</c:if>

    </body>
</html>
