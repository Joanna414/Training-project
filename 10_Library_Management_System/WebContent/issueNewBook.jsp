<%@page import="com.montran.pojo.BookIssue"%>
<%@page import="org.apache.taglibs.standard.lang.jpath.expression.RoundFunction"%>
<%@page import="java.util.Date"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Issue New Book</title>
</head>
<body>
	
	<h3>Issue New Book</h3>
	<br>
	<hr>
	<html:form action="/issueBook" method="post">
		<table>

			<tr>
				<td>Issue Serial Number</td>
				<td><html:text property="issueSerialNumber" readonly="true" /></td>
			</tr>
			<tr>
				<td>Member Code</td>
				<td><html:text property="memberCode"  /></td>
				<td><html:submit property="member" value="getMember">Verify Member</html:submit>
			</tr>
			<tr>
				<td>Name</td>
				<td><html:text property="memberName"  /></td>
			</tr>

			<tr>
				<td>Book Code</td>
				<td><html:text property="bookCode"  /></td>
				<td><html:submit property="book" value="getBook">Get Book Details</html:submit></td>
			</tr>
			<tr>
				<td>Title</td>
				<td><html:text property="bookName"  /></td>
			</tr>
			<tr>
				<td>Author</td>
				<td><html:text property="bookAuthor"  /></td>
			</tr>

			<tr>
				<td>Date of issue</td>
				<td><html:text property="issueDate"  /></td>
			</tr>
			<tr>
				<td>Date of return</td>
				<td><html:text property="dueDate"  /></td>
			</tr>
			<tr>
				<td></td>
				<td><html:submit property="issue" value="issueBook">Issue Book</html:submit></td>
				<td></td>
			</tr>

		</table>
	</html:form>
<div style="color:red">
	<html:errors/>
	</div>
</body>
</html>