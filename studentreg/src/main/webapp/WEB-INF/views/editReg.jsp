<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html lang="en">
<head>
<title>Home</title>
<meta charset="utf-8">
</head>
<body>
	<h1>Student Registration</h1>
	<c:set var="context" value="${pageContext.request.contextPath}" />
		<c:if test="${message != null}">
		<div id="SUCCESS_MESSAGE_BOX" style="background-color:green;color:white;padding:10px;width:50%;" >
			<h3>${message}</h3>
		</div>
	</c:if>
	<c:if test="${errorMessage != null}">
		<div id="ERROR_MESSAGE_BOX" style="background-color:red;color:white;padding:10px;width:50%;" >
			<h3 >Error : ${errorMessage}</h3>
		</div>
	</c:if>
	<br />
	<form method="post" action="save">
		
		UserName: <input type="text" name="userName" placeholder="User Name"
			value="${student.userName}"><br /><br /> 
			
		Password: <input type="password" name="password"
			placeholder="Password" value="${student.password}"></br> <br>
		
		Gender::<input type="radio" name="gender" value="male"
			${student.gender == 'male'? 'checked="true"' : ''}> Male
		<input type="radio" name="gender" value="female"
			${student.gender == 'female'? 'checked="true"':''}> Female <br />
		<br /> 
		Country:<select name="country">
			<option>Select...</option>
			<option value="india"
				${student.country == 'india' ? 'selected="selected"' : '' }>India</option>
			<option value="pakistan"
				${student.country == 'pakistan' ? 'selected="selected"' : ''}>Pakistan</option>
			<option value="australia"
				${student.country == 'australia' ? 'selected="selected"' : ''}>Australia</option>
			<option value="america"
				${student.country == 'america' ? 'selected="selected"' : '' }>America</option>
		</select><br /> <br /> 
		
		AboutYou:
		<textarea rows="4" cols="50" name="aboutYou">${student.aboutYou} </textarea>
		<br />
		<br />
		
		 Community: <input type="checkbox" name="community1"
			value="Spring"
			${student.community1 == 'Spring'? 'checked="true"' : ''}>
		Spring <input type="checkbox" name="community2" value="Structs"
			${student.community2 == 'Structs'? 'checked="true"' : ''}>
		Structs <input type="checkbox" name="community3" value="Hibernate"
			${student.community3 == 'Hibernate'? 'checked="true"' : ''}>
		Hibernate <br /> <br />
		
		 <input type="hidden" name="id" value="${student.id}">


		<c:if test="${student.id == null}">
			<input type="submit" value="Register">
		</c:if>

		<c:if test="${student.id != null}">
			<input type="submit" value="Update">
		</c:if>


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
					<td><a href="${context}/student/edit?id=${emp.id}">Edit</a> &nbsp;&nbsp; 
						<a href="${context}/student/delete/${emp.id}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>
