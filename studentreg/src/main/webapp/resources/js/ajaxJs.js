$(document).ready(function() {
	$('#BUTTION').click(function() {
		$.ajax({
			url : '../ajaxServlet',
			data : {
				userName : $('#USER_NAME').val()
			},
			success : function(responseText) {
				console.info(responseText);
				$("#RESPONSE").text(responseText);
			}
		});
	});
	
});

function editEmployee(id){
	console.info("hai..");
	$.ajax({
			url:'editEmployeeServlet',
			method:'GET',
			data : {
				userId : id
			},
			success : function(response) {
				$("#SAVE_FORM").html(response);
			}
		});

}



function deleteEmployee(id){
	$.ajax({
			url:'deleteEmployee',
			method:'GET',
			data : {
				employeeId : id
			},
			success : function(responseText) {
				$("#TABLE").html(responseText);

			}
		});
}