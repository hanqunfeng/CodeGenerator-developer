<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/jsp/common/includes.jsp"%>
<link href="${_contextPath}/resource/css/datepicker.css"
	  rel="stylesheet" />
<link href="${_contextPath}/resource/css/jquery.validator.css"
	  rel="stylesheet" />
<script type="text/javascript"
		src="${_contextPath}/resource/js/jquery.validator.js"></script>
<script type="text/javascript"
		src="${_contextPath}/resource/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript"
		src="${_contextPath}/resource/js/i18n/jquery.validator.<fmt:message key='locale'/>.js"></script>
<script type="text/javascript"
		src="${_contextPath}/resource/js/i18n/datepicker/bootstrap-datepicker.<fmt:message key='locale'/>.js"></script>
<script type="text/javascript">
    $(function(){
$('#logTime').datepicker({
autoclose:true,
clearBtn:true,
todayBtn:true,
todayHighlight:true,
format:"yyyy-mm-dd"
}).on("hide",function(){
$('#logTime').trigger("blur")
});



        $('#contentForm').validator({theme:"yellow_right"});
    });
</script>

<div class="highlight">
	<form class="form-horizontal" role="form" action="${_contextPath }/auth/systemLogger/${method}.do" id="contentForm" method="post">
<c:if test="${not empty dataObj.id }">
	<input type="hidden" id="id" name="id"  style="width:220px;" value="${dataObj.id}"/>

</c:if>
<div class="form-group ">
	<label for="logClientIp" class="col-sm-3 control-label"><fmt:message
			key="systemLogger.logClientIp" />:<span class="red">*</span></label>
	<div class="col-sm-4">
		<input type="text" class="input-sm" name="logClientIp" id="logClientIp"
			   placeholder="<fmt:message key="systemLogger.logClientIp.placeholder"/>" data-rule="required" style="width:220px;" value="${dataObj.logClientIp}">
	</div>
	<div class="col-sm-5"></div>
</div>

<div class="form-group ">
	<label for="logUri" class="col-sm-3 control-label"><fmt:message
			key="systemLogger.logUri" />:<span class="red">*</span></label>
	<div class="col-sm-4">
		<input type="text" class="input-sm" name="logUri" id="logUri"
			   placeholder="<fmt:message key="systemLogger.logUri.placeholder"/>" data-rule="required" style="width:220px;" value="${dataObj.logUri}">
	</div>
	<div class="col-sm-5"></div>
</div>

<div class="form-group ">
	<label for="logType" class="col-sm-3 control-label"><fmt:message
			key="systemLogger.logType" />:<span class="red">*</span></label>
	<div class="col-sm-4">
		<input type="text" class="input-sm" name="logType" id="logType"
			   placeholder="<fmt:message key="systemLogger.logType.placeholder"/>" data-rule="required" style="width:220px;" value="${dataObj.logType}">
	</div>
	<div class="col-sm-5"></div>
</div>

<div class="form-group ">
	<label for="logMethod" class="col-sm-3 control-label"><fmt:message
			key="systemLogger.logMethod" />:<span class="red">*</span></label>
	<div class="col-sm-4">
		<input type="text" class="input-sm" name="logMethod" id="logMethod"
			   placeholder="<fmt:message key="systemLogger.logMethod.placeholder"/>" data-rule="required" style="width:220px;" value="${dataObj.logMethod}">
	</div>
	<div class="col-sm-5"></div>
</div>

<div class="form-group ">
	<label for="logParamData" class="col-sm-3 control-label"><fmt:message
			key="systemLogger.logParamData" />:<span class="red">*</span></label>
	<div class="col-sm-4">
		<input type="text" class="input-sm" name="logParamData" id="logParamData"
			   placeholder="<fmt:message key="systemLogger.logParamData.placeholder"/>" data-rule="required" style="width:220px;" value="${dataObj.logParamData}">
	</div>
	<div class="col-sm-5"></div>
</div>

<div class="form-group ">
	<label for="logSessionId" class="col-sm-3 control-label"><fmt:message
			key="systemLogger.logSessionId" />:<span class="red">*</span></label>
	<div class="col-sm-4">
		<input type="text" class="input-sm" name="logSessionId" id="logSessionId"
			   placeholder="<fmt:message key="systemLogger.logSessionId.placeholder"/>" data-rule="required" style="width:220px;" value="${dataObj.logSessionId}">
	</div>
	<div class="col-sm-5"></div>
</div>

<div class="form-group ">
	<label for="logTime" class="col-sm-3 control-label"><fmt:message
			key="systemLogger.logTime" />:<span class="red">*</span></label>
	<div class="col-sm-4">
		<input type="text" class="input-sm" name="logTime" id="logTime"
			   placeholder="<fmt:message key="systemLogger.logTime.placeholder"/>" data-rule="required" style="width:220px;" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${dataObj.logTime }" />">
	</div>
	<div class="col-sm-5"></div>
</div>

<div class="form-group ">
	<label for="logReturmTime" class="col-sm-3 control-label"><fmt:message
			key="systemLogger.logReturmTime" />:<span class="red">*</span></label>
	<div class="col-sm-4">
		<input type="text" class="input-sm" name="logReturmTime" id="logReturmTime"
			   placeholder="<fmt:message key="systemLogger.logReturmTime.placeholder"/>" data-rule="required" style="width:220px;" value="${dataObj.logReturmTime}">
	</div>
	<div class="col-sm-5"></div>
</div>

<div class="form-group ">
	<label for="logReturnData" class="col-sm-3 control-label"><fmt:message
			key="systemLogger.logReturnData" />:<span class="red">*</span></label>
	<div class="col-sm-4">
		<input type="text" class="input-sm" name="logReturnData" id="logReturnData"
			   placeholder="<fmt:message key="systemLogger.logReturnData.placeholder"/>" data-rule="required" style="width:220px;" value="${dataObj.logReturnData}">
	</div>
	<div class="col-sm-5"></div>
</div>

<div class="form-group ">
	<label for="logHttpStatusCode" class="col-sm-3 control-label"><fmt:message
			key="systemLogger.logHttpStatusCode" />:<span class="red">*</span></label>
	<div class="col-sm-4">
		<input type="text" class="input-sm" name="logHttpStatusCode" id="logHttpStatusCode"
			   placeholder="<fmt:message key="systemLogger.logHttpStatusCode.placeholder"/>" data-rule="required" style="width:220px;" value="${dataObj.logHttpStatusCode}">
	</div>
	<div class="col-sm-5"></div>
</div>

<div class="form-group ">
	<label for="logTimeConsuming" class="col-sm-3 control-label"><fmt:message
			key="systemLogger.logTimeConsuming" />:<span class="red">*</span></label>
	<div class="col-sm-4">
		<input type="text" class="input-sm" name="logTimeConsuming" id="logTimeConsuming"
			   placeholder="<fmt:message key="systemLogger.logTimeConsuming.placeholder"/>" data-rule="required" style="width:220px;" value="${dataObj.logTimeConsuming}">
	</div>
	<div class="col-sm-5"></div>
</div>

<div class="form-group ">
	<label for="logDesc" class="col-sm-3 control-label"><fmt:message
			key="systemLogger.logDesc" />:<span class="red">*</span></label>
	<div class="col-sm-4">
		<input type="text" class="input-sm" name="logDesc" id="logDesc"
			   placeholder="<fmt:message key="systemLogger.logDesc.placeholder"/>" data-rule="required" style="width:220px;" value="${dataObj.logDesc}">
	</div>
	<div class="col-sm-5"></div>
</div>

<div class="form-group ">
	<label for="logUser" class="col-sm-3 control-label"><fmt:message
			key="systemLogger.logUser" />:<span class="red">*</span></label>
	<div class="col-sm-4">
		<input type="text" class="input-sm" name="logUser" id="logUser"
			   placeholder="<fmt:message key="systemLogger.logUser.placeholder"/>" data-rule="required" style="width:220px;" value="${dataObj.logUser}">
	</div>
	<div class="col-sm-5"></div>
</div>


		<div class="form-group">

			<div class="col-sm-offset-3 col-sm-1 text-right">

				<button type="submit" class="btn btn-primary">
					<fmt:message key="common.submit" />
				</button>
			</div>

			<div class="col-sm-8 text-left">
				<a href="${_contextPath}${parentUrl}" class="btn"> <fmt:message
						key="common.back" /></a>
			</div>
		</div>

	</form>
</div>

