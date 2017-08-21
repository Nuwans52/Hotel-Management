$(function() {
	//Form validation
	$("#hotel-add-form").validate({
			  success: function(label) {
			    label.addClass("valid").text("Ok!")
			  },
		submitHandler : function(form) {
			formSubmit();
		},
		rules : {
			htlName : "required",
			htlEmail : {
				email : true
			},
			htlStreet : "required",
			districts : "required",
			htlPhoneNo: {
			      minlength: 10,
			    }
		}
	});
});

//Hotel saving form submittion
function formSubmit() {
	$.ajax({
		url : context + "/save",
		data : $("#hotel-add-form").serialize(),
		type : "POST",
		success : function(data, txtStatus, exp) {
			window.location.reload();
		},
		error : function(data, txtStatus, exp) {

		}
	});
}