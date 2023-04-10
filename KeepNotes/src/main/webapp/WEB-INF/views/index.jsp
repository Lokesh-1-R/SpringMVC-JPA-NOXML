<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Keep-Note Application</title>
	<style>
		h2 {
			color: #0066CC;
		}
		.for {
		  margin: auto;
		
			border: 1px solid #CCC;
			padding: 10px;
			max-width: 500px;
			border-radius: 5px;
			box-shadow: 2px 2px 5px rgba(0,0,0,0.3);
		}
		input[type="text"],input[type="textarea"]  {
			width: 100%;
			padding: 8px;
			border: 1px solid #CCC;
			border-radius: 5px;
			box-sizing: border-box;
			margin-bottom: 10px;
			font-size: 16px;
		}
		select {
			width: 100%;
			padding: 8px;
			border: 1px solid #CCC;
			border-radius: 5px;
			margin-bottom: 10px;
			font-size: 16px;
		}
		.btn{
			background-color: #0066CC;
			color: #FFF;
			border: none;
			padding: 10px;
			border-radius: 15px;
			font-size: 16px;
			cursor: pointer;
		}
		table {
			border-collapse: collapse;
			width: 100%;
		}
		table td, table th {
			border: 1px solid #CCC;
			padding: 8px;
			text-align: left;
			font-size: 16px;
		}
		table th ,.tr {
			background-color: #0066CC;
			color: #FFF;
		}
		.heading{
		text-align: center;
		}
	</style>
</head>


<body>
	<h2 class="heading">Keep Note Application </h2>
	
	<form class ="for" action='add' method="post">
	  
	 
	  Title:<br>
	  <input type="text" name="noteTitle"><br>
	  Content:<br>
	  <input type="textarea" name="noteContent"><br>
	  Status:<br>
	  <select  name= "noteStatus">
		  <option value="active">Active</option>
		  <option value="inactive">Inactive</option>
	  </select>
	  <br>
	  <br>
	  <input class = "btn" type="submit" value="Submit">
	  
	</form> 
	<br>
	<c:if test="${not empty errorMessage}">
	   <p style="color:red">Error</p>: ${errorMessage}
	</c:if>
	<h2 class="heading">Saved Notes</h2>
	<table border="2">
	
	<tr class="tr">
		<td style="text-align: center">Title</td>
		<td style="text-align: center">Content</td>
		<td style="text-align: center">Status</td>
		<td style="text-align: center">Created at</td>
		<td colspan ="2" style="text-align: center"> Action</td>
	</tr>
	<c:forEach items="${noteList}" var="note">
		
		<tr>
		<td>${note.noteTitle}</td>
		
		<td>${note.noteContent}</td>
		
		<td>${note.noteStatus}</td>
		
		<td>${note.createdAt}</td>
		
		<td>
		<form action="delete" method="post">
			<input type="hidden" id="noteId" name="noteId" value="${note.noteId}"/>
			<button  style="background-color :red " type="submit ">Delete</button>
		</form>
		</td>
		
		<td>
		<form action="updateNote" method="post">
			<input type="hidden" id="noteId" name="noteId" value="${note.noteId}"/>
			<button  style="background-color:yellow" type="submit ">Update</button>
		</form>
		</td>
		</tr>
		</c:forEach>	
	</table>
	
</body>
</body>

</html>