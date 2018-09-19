<#assign className = table.className>   
<#assign classNameFirstLower = className?uncap_first>   
<#assign classNameLowerCase = className?lower_case>
<#if table.idColumn.javaType =="java.lang.Integer">
<#assign pkJavaType = "java.lang.Long">
<#else>
<#assign pkJavaType = table.idColumn.javaType>
</#if>

<%@ include file="/WEB-INF/views/jsp/common/includes.jsp"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<link href="$\{_contextPath}/resource/css/netqin.css" rel="stylesheet" />
<script type="text/javascript"
	src="$\{_contextPath}/resource/js/i18n/netqin.list.<fmt:message key='locale'/>.js"></script>
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
		action="$\{_contextPath}/${modulName}/${classNameFirstLower}/list.do" method="POST">
			<table width="100%" class="table table-padding-4 borderless" style="border: 0px; padding: 0px;margin:0px;"
				cellspacing="100">
		<tr>
		<td class="text-right" width="10%"><fmt:message key="${classNameFirstLower}.id" /></td>
			<td><input type="text" class="input-sm" id="id" name="id"
						autocomplete=off value="$\{queryBean.id}"
						placeholder="<fmt:message key='${classNameFirstLower}.id.placeholder'/>">
					</td>
		</tr>
		<tr>	
		<td  class="right">
		<input type="hidden" name="sortName" id="sortName" value="$\{sorter.sortName}" /> 
		<input type="hidden" name="sortType" id="sortType" value="$\{sorter.sortType}" /> 
		<button type="submit" id="submitbtn" class="btn btn-default btn-sm">
			<fmt:message key="common.submit" />
		</button>
		</td>
	</tr>
</table>
</form>
</div>
</div>
<a href="$\{_contextPath}/${modulName}/${classNameFirstLower}/edit.do" class="btn btn-success btn-xs no-hover"><fmt:message
		key="common.create" /></a>
<button class="btn btn-danger btn-xs" id="delete">
	<fmt:message key="common.delete" />
</button>

<form id="resultForm" name="resultsForm" action="$\{_contextPath}/${classNameFirstLower}/delete.do" method="POST">
<div class="table-responsive">
<table id="resultsTable"
			class="table table-striped table-bordered table-hover">
	<thead>
		<tr>
		<th><input type="checkbox" name="selectAll" id="selectAll" />
					<fmt:message key="common.choose" /></th>
			<@generateHeader/>
		<th ><fmt:message key="common.operate" /></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="$\{results}" var="item">
					<tr>
						<td>
							<input type="checkbox" name="ids" value="$\{item.id}" class="noborder"/>
					</td>
						<@generateResult/>
						<td>
						<a href="$\{_contextPath}/${modulName}/${classNameFirstLower}/edit.do?id=$\{item.id}"
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

<#macro generateResult>
		<#list table.columns as column>
		<#if column.isDateTimeColumn >
		<td><fmt:formatDate pattern="yyyy-MM-dd" value="$\{item.${column.columnNameFirstLower} }" /></td>
		<#elseif column.pk>
			<td >$\{item.id}</td>
		<#else>
			 <td >$\{item.${column.columnNameFirstLower}}</td>
		</#if>
		</#list>
</#macro>
<#macro generateHeader>
		<#list table.columns as column>
		<#if column.pk>
		<th class="header" ><span
				style="display: none;">id</span><fmt:message key="${classNameFirstLower}.id"/><i
						class="icon-sort"></i></th>
		<#else>
		<th class="header" ><span
				style="display: none;">${column.columnNameFirstLower}</span><fmt:message key="${classNameFirstLower}.${column.columnNameFirstLower}"/><i
						class="icon-sort"></i></th>
		</#if>
			
		</#list>
</#macro>