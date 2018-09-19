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
		})
	});
			
	
	$('#contentForm').validator({theme:"yellow_right"});
});
</script>
<form	action="${_contextPath }/test/systemLogger/${method}.do" id="contentForm" method="post">
<div class="table-responsive">
	<table width="100%" style="border: 0px;" class="table table-striped table-bordered">
				<c:if test="${not empty dataObj.id }">
					<input type="hidden" id="id" name="id"  style="width:220px;" value="${dataObj.id}"/> 
				
					</c:if>
					<tr>
							<td align="right" width="25%">
								<fmt:message key="systemLogger.logClientIp" />:
								<span class="red">*</span>
							</td>
							<td align="left" ><input type="text" class="input-sm" name="logClientIp" id="logClientIp"
				placeholder="<fmt:message key="systemLogger.logClientIp.placeholder"/>" data-rule="required" style="width:220px;" value="${dataObj.logClientIp}"></td>
						</tr>
						
					<tr>
							<td align="right" width="25%">
								<fmt:message key="systemLogger.logUri" />:
								<span class="red">*</span>
							</td>
							<td align="left" ><input type="text" class="input-sm" name="logUri" id="logUri"
				placeholder="<fmt:message key="systemLogger.logUri.placeholder"/>" data-rule="required" style="width:220px;" value="${dataObj.logUri}"></td>
						</tr>
						
					<tr>
							<td align="right" width="25%">
								<fmt:message key="systemLogger.logType" />:
								<span class="red">*</span>
							</td>
							<td align="left" ><input type="text" class="input-sm" name="logType" id="logType"
				placeholder="<fmt:message key="systemLogger.logType.placeholder"/>" data-rule="required" style="width:220px;" value="${dataObj.logType}"></td>
						</tr>
						
					<tr>
							<td align="right" width="25%">
								<fmt:message key="systemLogger.logMethod" />:
								<span class="red">*</span>
							</td>
							<td align="left" ><input type="text" class="input-sm" name="logMethod" id="logMethod"
				placeholder="<fmt:message key="systemLogger.logMethod.placeholder"/>" data-rule="required" style="width:220px;" value="${dataObj.logMethod}"></td>
						</tr>
						
					<tr>
							<td align="right" width="25%">
								<fmt:message key="systemLogger.logParamData" />:
								<span class="red">*</span>
							</td>
							<td align="left" ><input type="text" class="input-sm" name="logParamData" id="logParamData"
				placeholder="<fmt:message key="systemLogger.logParamData.placeholder"/>" data-rule="required" style="width:220px;" value="${dataObj.logParamData}"></td>
						</tr>
						
					<tr>
							<td align="right" width="25%">
								<fmt:message key="systemLogger.logSessionId" />:
								<span class="red">*</span>
							</td>
							<td align="left" ><input type="text" class="input-sm" name="logSessionId" id="logSessionId"
				placeholder="<fmt:message key="systemLogger.logSessionId.placeholder"/>" data-rule="required" style="width:220px;" value="${dataObj.logSessionId}"></td>
						</tr>
						
					<tr>
							<td align="right" width="25%">
								<fmt:message key="systemLogger.logTime" />:
								<span class="red">*</span>
							</td>
							<td align="left" ><input type="text" class="input-sm" name="logTime" id="logTime"
				placeholder="<fmt:message key="systemLogger.logTime.placeholder"/>" data-rule="required" style="width:220px;" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${dataObj.logTime }" />"></td>
						</tr>
						
					<tr>
							<td align="right" width="25%">
								<fmt:message key="systemLogger.logReturmTime" />:
								<span class="red">*</span>
							</td>
							<td align="left" ><input type="text" class="input-sm" name="logReturmTime" id="logReturmTime"
				placeholder="<fmt:message key="systemLogger.logReturmTime.placeholder"/>" data-rule="required" style="width:220px;" value="${dataObj.logReturmTime}"></td>
						</tr>
						
					<tr>
							<td align="right" width="25%">
								<fmt:message key="systemLogger.logReturnData" />:
								<span class="red">*</span>
							</td>
							<td align="left" ><input type="text" class="input-sm" name="logReturnData" id="logReturnData"
				placeholder="<fmt:message key="systemLogger.logReturnData.placeholder"/>" data-rule="required" style="width:220px;" value="${dataObj.logReturnData}"></td>
						</tr>
						
					<tr>
							<td align="right" width="25%">
								<fmt:message key="systemLogger.logHttpStatusCode" />:
								<span class="red">*</span>
							</td>
							<td align="left" ><input type="text" class="input-sm" name="logHttpStatusCode" id="logHttpStatusCode"
				placeholder="<fmt:message key="systemLogger.logHttpStatusCode.placeholder"/>" data-rule="required" style="width:220px;" value="${dataObj.logHttpStatusCode}"></td>
						</tr>
						
					<tr>
							<td align="right" width="25%">
								<fmt:message key="systemLogger.logTimeConsuming" />:
								<span class="red">*</span>
							</td>
							<td align="left" ><input type="text" class="input-sm" name="logTimeConsuming" id="logTimeConsuming"
				placeholder="<fmt:message key="systemLogger.logTimeConsuming.placeholder"/>" data-rule="required" style="width:220px;" value="${dataObj.logTimeConsuming}"></td>
						</tr>
						
					<tr>
							<td align="right" width="25%">
								<fmt:message key="systemLogger.logDesc" />:
								<span class="red">*</span>
							</td>
							<td align="left" ><input type="text" class="input-sm" name="logDesc" id="logDesc"
				placeholder="<fmt:message key="systemLogger.logDesc.placeholder"/>" data-rule="required" style="width:220px;" value="${dataObj.logDesc}"></td>
						</tr>
						
					<tr>
							<td align="right" width="25%">
								<fmt:message key="systemLogger.logUser" />:
								<span class="red">*</span>
							</td>
							<td align="left" ><input type="text" class="input-sm" name="logUser" id="logUser"
				placeholder="<fmt:message key="systemLogger.logUser.placeholder"/>" data-rule="required" style="width:220px;" value="${dataObj.logUser}"></td>
						</tr>
						
		<tr>
			<td class="text-right" >
			<button type="submit" class="btn btn-primary"><fmt:message key="common.submit"/></button>
		
		</td><td class="text-left" ><a href="${_contextPath}${parentUrl}" class="btn">
					<fmt:message key="common.back"/></a></td>
		</tr>
	</table>
</form>
				
