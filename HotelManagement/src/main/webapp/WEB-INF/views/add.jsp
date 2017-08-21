<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>

<div class="row">
	<div class="col-lg-3 "></div>
	<div class="col-lg-6">
		<div class="hpanel">
			<div class="panel-heading text-center">
				<div class="panel-tools">
					<h3 class="showhide" style="font-family: serif; color: navy;">
						Add New Hotel<i class="fa fa-chevron-up"></i>
					</h3>
				</div>
				<div class="text-right">
					<a href="${pageContext.request.contextPath}/"><span>Search</span>
						<i class="glyphicon glyphicon-hand-right"></i></a>
				</div>
			</div>
			<div class="panel-body">

				<div class="text-left">
					<form:form class="form-horizontal col-sm-12" id="hotel-add-form"
						modelAttribute="newHotel">
						<div class="form-group">
							<label class="col-sm-3 control-label"><span
								style="color: red;">*</span>Hotel:</label>
							<div class="col-sm-8">
								<form:input path="htlName" type="text" id="htlName"
									placeholder="Enter Hotel Name" class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-3 control-label">Contact No:</label>
							<div class="col-sm-8">
								<form:input path="htlPhoneNo" id="htlPhoneNo" type="text"
									placeholder="Enter Contact Number" class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-3 control-label">E-Mail:</label>
							<div class="col-sm-8">
								<form:input path="htlEmail" id="htlEmail" type="text"
									placeholder="Enter E-Mail" class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-3 control-label"><span
								style="color: red;">*</span>Street:</label>
							<div class="col-sm-8">
								<form:input path="htlStreet" id="htlStreet" type="text"
									placeholder="Enter Street" class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-3 control-label"><span
								style="color: red;">*</span>District:</label>
							<div class="col-sm-8">
								<select name="districts" class="form-control select2"
									id="districts">
									<option value="0">Select a District</option>
									<c:forEach var="districtList" items="${districtList }">
										<option value="${districtList.dtrId }">${districtList.dtrName }</option>
									</c:forEach>
								</select>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-3 control-label"><span
								style="color: red;">*</span>City:</label>
							<div class="col-sm-8">
								<form:select class="form-control select2" path="MCity.ctyId"
									id="cities">
									<option value="0">Select a District</option>
								</form:select>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-3 control-label">Active:</label>
							<div class="col-sm-8">
								<form:select class="form-control" path="htlActive"
									id="htlActive">
									<form:option value="1">Yes</form:option>
									<form:option value="0">No</form:option>
								</form:select>
							</div>
						</div>

						<div class="modal-footer">
							<div class="form-group">
								<div class="col-sm-3"></div>
								<div class="col-sm-8">
									<button type="reset" class="btn btn-danger">
										<i class="glyphicon glyphicon-remove"></i><span> Cancel</span>
									</button>
									<button type="submit" class="btn btn-success">
										<i class="glyphicon glyphicon-check"></i><span> Save</span>
									</button>
								</div>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
</body>