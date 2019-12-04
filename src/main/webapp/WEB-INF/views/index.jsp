<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>KeepNote</title>
</head>
<body>
	<!-- Create a form which will have text boxes for Note ID, title, content and status along with a Send 
		 button. Handle errors like empty fields -->

	<h1>Add New Note</h1>
	<form action="add" method="post">
		<table>
			<tr>
				<td>Note Id :</td>
				<td><input type="text" name="noteId" /></td>
			</tr>
			<tr>
				<td>Note Title :</td>
				<td><input type="text" name="noteTitle" /></td>
			</tr>
			<tr>
				<td>Note Content :</td>
				<td><input type="text" name="noteContent" /></td>
			</tr>
			<tr>
				<td>Note Status :</td>
				<td><input type="text" name="noteStatus" /></td>
			</tr>
			<tr>
			<td><input type="submit" value="Save" /></td>
			</tr>
		</table>
	</form>
<!-- display all existing notes in a tabular structure with Id, Title,Content,Status, Created Date and Action -->
	<h1>Notes List</h1>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Note Id</th>
			<th>Note Title</th>
			<th>Note Content</th>
			<th>Note Status</th>
			<th>Created Date</th>
			<th>Action</th>
		</tr>
		<c:forEach var="note" items="${noteList}">
			<tr>
				<td>${note.noteId}</td>
				<td>${note.noteTitle}</td>
				<td>${note.noteContent}</td>
				<td>${note.noteStatus}</td>
				<td>${note.createdAt}</td>
				<td>
				<form action="delete">
				<input type="hidden" name="noteId" id="noteId" value="${note.noteId}"/>
				<input type="submit" value="Delete" />
				</form>
				</td>
				<td>
				<form action="update">
				<input type="hidden" name="noteId" id="noteId" value="${note.noteId}"/>
				<input type="submit" value="Update" />
				</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br />
</body>
</html>