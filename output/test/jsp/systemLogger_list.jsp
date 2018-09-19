
<%@ include file="/WEB-INF/views/jsp/common/includes.jsp"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<link href="${_contextPath}/resource/css/netqin.css" rel="stylesheet" />
<script type="text/javascript"
	src="${_contextPath}/resource/js/i18n/netqin.list.<fmt:message key='locale'/>.js"></script>
<script type="text/javascript">
	jQuery(function($) {
	});
</script>

<div class="panel panel-info ">
	<div class="panel-heading" style="margin-bottom: 0px;">
		<h3 class="panel-title">
			<i class="icon-search"></i>
			<fmt:message key="common.form.search" />
		</h3>
	</div>
	<div class="panel-body">
<form id="queryForm" name="queryForm"
		action="${_contextPath}/test/systemLogger/list.do" method="POST">
			<table width="100%" class="table table-padding-4 borderless" style="border: 0px; padding: 0px;margin:0px;"
				cellspacing="100">
		<tr>
		<td class="text-right" width="10%"><fmt:message key="systemLogger.id" /></td>
			<td><input type="text" class="input-sm" id="id" name="id"
						autocomplete=off value="${queryBean.id}"
						placeholder="<fmt:message key='systemLogger.id.placeholder'/>">
					</td>
		</tr>
		<tr>	
		<td  class="right">
		<input type="hidden" name="sortName" id="sortName" value="${sorter.sortName}" /> 
		<input type="hidden" name="sortType" id="sortType" value="${sorter.sortType}" /> 
		<button type="submit" id="submitbtn" class="btn btn-default btn-sm">
			<fmt:message key="common.submit" />
		</button>
		</td>
	</tr>
</table>
</form>
</div>
</div>
<a href="${_contextPath}/test/systemLogger/edit.do" class="btn btn-success btn-xs no-hover"><fmt:message
		key="common.create" /></a>
<button class="btn btn-danger btn-xs" id="delete">
	<fmt:message key="common.delete" />
</button>

<form id="resultForm" name="resultsForm" action="${_contextPath}/systemLogger/delete.do" method="POST">
<div class="table-responsive">
<table id="resultsTable"
			class="table table-striped table-bordered table-hover">
	<thead>
		<tr>
		<th><input type="checkbox" name="selectAll" id="selectAll" />
					<fmt:message key="common.choose" /></th>
		<th class="header" ><span
				style="display: none;">id</span><fmt:message key="systemLogger.id"/><i
						class="icon-sort"></i></th>
			
		<th class="header" ><span
				style="display: none;">logClientIp</span><fmt:message key="systemLogger.logClientIp"/><i
						class="icon-sort"></i></th>
			
		<th class="header" ><span
				style="display: none;">logUri</span><fmt:message key="systemLogger.logUri"/><i
						class="icon-sort"></i></th>
			
		<th class="header" ><span
				style="display: none;">logType</span><fmt:message key="systemLogger.logType"/><i
						class="icon-sort"></i></th>
			
		<th class="header" ><span
				style="display: none;">logMethod</span><fmt:message key="systemLogger.logMethod"/><i
						class="icon-sort"></i></th>
			
		<th class="header" ><span
				style="display: none;">logParamData</span><fmt:message key="systemLogger.logParamData"/><i
						class="icon-sort"></i></th>
			
		<th class="header" ><span
				style="display: none;">logSessionId</span><fmt:message key="systemLogger.logSessionId"/><i
						class="icon-sort"></i></th>
			
		<th class="header" ><span
				style="display: none;">logTime</span><fmt:message key="systemLogger.logTime"/><i
						class="icon-sort"></i></th>
			
		<th class="header" ><span
				style="display: none;">logReturmTime</span><fmt:message key="systemLogger.logReturmTime"/><i
						class="icon-sort"></i></th>
			
		<th class="header" ><span
				style="display: none;">logReturnData</span><fmt:message key="systemLogger.logReturnData"/><i
						class="icon-sort"></i></th>
			
		<th class="header" ><span
				style="display: none;">logHttpStatusCode</span><fmt:message key="systemLogger.logHttpStatusCode"/><i
						class="icon-sort"></i></th>
			
		<th class="header" ><span
				style="display: none;">logTimeConsuming</span><fmt:message key="systemLogger.logTimeConsuming"/><i
						class="icon-sort"></i></th>
			
		<th class="header" ><span
				style="display: none;">logDesc</span><fmt:message key="systemLogger.logDesc"/><i
						class="icon-sort"></i></th>
			
		<th class="header" ><span
				style="display: none;">logUser</span><fmt:message key="systemLogger.logUser"/><i
						class="icon-sort"></i></th>
			
		<th ><fmt:message key="common.operate" /></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${results}" var="item">
					<tr>
						<td>
							<input type="checkbox" name="ids" value="${item.id}" class="noborder"/>
					</td>
			<td >${item.id}</td>
			 <td >${item.logClientIp}</td>
			 <td >${item.logUri}</td>
			 <td >${item.logType}</td>
			 <td >${item.logMethod}</td>
			 <td >${item.logParamData}</td>
			 <td >${item.logSessionId}</td>
		<td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.logTime }" /></td>
			 <td >${item.logReturmTime}</td>
			 <td >${item.logReturnData}</td>
			 <td >${item.logHttpStatusCode}</td>
			 <td >${item.logTimeConsuming}</td>
			 <td >${item.logDesc}</td>
			 <td >${item.logUser}</td>
						<td>
						<a href="${_contextPath}/test/systemLogger/edit.do?id=${item.id}"
							class="btn btn-info btn-minier"><fmt:message
									key="common.edit" /></a>
						</td>
					</tr>
		</c:forEach>
	</tbody>
</table>
	</div>
</form>
</form>
<div class="row" style="margin: 0px;">
	<c:import url="/WEB-INF/views/jsp/common/pagination.jsp" />
</div>

