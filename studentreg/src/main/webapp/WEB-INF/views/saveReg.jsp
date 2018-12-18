<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<c:set var="context" value="${pageContext.request.contextPath}" />
<head>
<link href="${context}/resources/css/style.css" rel="stylesheet">
<title>Employee</title>
<meta charset="utf-8">
</head>
<body>
	<h1>Student Registration</h1>
	<c:if test="${message != null}">
		<div id="SUCCESS_MESSAGE_BOX" class="alert_success">
			<h3>${message}</h3>
		</div>
	</c:if>
	<c:if test="${errorMessage != null}">
		<div id="ERROR_MESSAGE_BOX" class="alert_error">
			<h3 >Error : ${errorMessage}</h3>
		</div>
	</c:if>
	
	<br/>
	<form method="post" action="save">

		UserName: <input type="text" name="userName" placeholder="User Name"><br /> <br /> 
		
		Password: <input type="password" name="password" placeholder="Password"></br> <br> 
		
		Gender: 
			<input type="radio" name="gender" value="male"> Male 
			<input type="radio" name="gender" value="female"> Female <br /> <br />
			
		Country:
			<select name="country">
				<option>Select...</option>
				<option value="india">India</option>
				<option value="pakistan">Pakistan</option>
				<option value="australia">Australia</option>
				<option value="america">America</option>
			</select><br /> <br /> 
		
		AboutYou: <textarea rows="4" cols="50" name="aboutYou"> </textarea> <br /> <br />
		 
		Community:
			 <input type="checkbox" name="community1" value="Spring">Spring 
			 <input type="checkbox" name="community2" value="Structs"> Structs 
			 <input type="checkbox" name="community3" value="Hibernate"> Hibernate <br /> <br />
		 
			 <input type="submit" value="Register">

	</form>
	<br>
	<div id="TABLE">
		<table border="1" cellpadding="5">
			<caption>
				<h2>List of Students</h2>
			</caption>
			<tr>
				<th>Name</th>
				<th>Gender</th>
				<th>Country</th>
				<th>About You</th>
				<th>Community</th>
				<th>Action</th>
			</tr>
			<c:forEach var="emp" items="${list}">
				<tr>
					<td><c:out value="${emp.userName}" /></td>
					<td><c:out value="${emp.gender}" /></td>
					<td><c:out value="${emp.country}" /></td>
					<td><c:out value="${emp.aboutYou}" /></td>
					<td><c:out value="${emp.community}" /></td>
					<td><a href="${context}/student/edit?id=${emp.id}">Edit</a>
						&nbsp;&nbsp; <a href="${context}/student/delete/${emp.id}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>
