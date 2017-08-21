$(function() {
	$(".select2").select2();
	$("#districts").on(
			'change',
			function() {
				var $cities = $("#cities");
				$cities.find('option').remove();
				$('<option>').val(0).text("Select a City").appendTo($cities);
				$cities.val(0).trigger("change");
				$.ajax({
					url : context + "/city_load",
					data : "dtrId= " + $("#districts").val(),
					type : "POST",
					success : function(data, txtStatus, exp) {
						$.each(data, function(index, value) {
							$('<option>').val(value.ctyId).text(value.ctyName)
									.appendTo($cities);
						});
					},
					error : function(data, txtStatus, exp) {
					}
				});
			});
});