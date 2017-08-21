<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>


<div class="row">
	<div class="col-lg-1 "></div>
	<div class="col-lg-10 ">
		<div class="hpanel">
			<div class="panel-heading text-center">
				<div class="panel-tools">
					<h3 class="showhide" style="font-family: serif; color: navy;">
						Welcome to the Hotel Collection<i class="fa fa-chevron-up"></i>
					</h3>
				</div>
				&nbsp;
			</div>
			<div class="panel-body">
				<div class="text-left">
					<a href="${pageContext.request.contextPath}/new_hotel"> <i
						class="glyphicon glyphicon-hand-left"></i><span> New Hotel</span></a>
				</div>
				<div class="text-right">
					<form class="form-inline">
						<div class="form-group col-sm-5"></div>
						<div class="form-group col-sm-3">
							<label class="col-sm-3 control-label">District:</label>
							<div class="col-sm-8">
								<select class="form-control select2" id="districts">
									<option value="0">Select a District</option>
									<c:forEach var="districtList" items="${districtList }">
										<option value="${districtList.dtrId }">${districtList.dtrName }</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group col-sm-3">
							<label class="col-sm-3 control-label">City:</label>
							<div class="col-sm-8">
								<select class="form-control select2" id="cities">
									<option value="0">Select a District</option>
								</select>
							</div>
						</div>
						<button type="button" class="btn btn-info" onclick="filData()">
							<span class="glyphicon glyphicon-search"></span> Search
						</button>
					</form>
					<br />
				</div>

				<div class="table-responsive">
					<div class="dataTables_wrapper form-inline dt-bootstrap no-footer">
						<div class="row"></div>
						<table id="hotel-view"
							class="table table-striped table-bordered table-hover dataTable no-footer"
							role="grid" style="width: 100%;">
							<thead>
								<tr role="row">
									<th class="sorting_asc text-center" tabindex="0"
										aria-controls="" rowspan="1" colspan="1" aria-sort="ascending"
										aria-label="Name: activate to sort column descending"
										style="width: 142px;">Hotel</th>
									<th class="sorting text-center" tabindex="0" aria-controls=""
										rowspan="1" colspan="1"
										aria-label="Position: activate to sort column ascending"
										style="width: 175px;">Phone Number</th>
									<th class="sorting text-center" tabindex="0" aria-controls=""
										rowspan="1" colspan="1"
										aria-label="Position: activate to sort column ascending"
										style="width: 175px;">E-mail</th>
									<th class="sorting text-center" tabindex="0" aria-controls=""
										rowspan="1" colspan="1"
										aria-label="Position: activate to sort column ascending"
										style="width: 175px;">Street</th>
									<th class="sorting text-center" tabindex="0" aria-controls=""
										rowspan="1" colspan="1"
										aria-label="Position: activate to sort column ascending"
										style="width: 175px;">Status</th>
								</tr>
							</thead>
							<tbody></tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>