$(function() {
	$('#hotel-view').DataTable();
});

function filData() {
	$('#hotel-view').dataTable().fnDestroy();
	$('#hotel-view').DataTable({
		"ajax" : context + '/hotel_search?ctyId=' + $("#cities").val()
	});
}