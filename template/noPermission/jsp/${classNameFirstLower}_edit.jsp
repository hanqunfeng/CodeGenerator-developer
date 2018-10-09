<#assign className = table.className>
<#assign classNameFirstLower = className?uncap_first>
<#assign classNameLowerCase = className?lower_case>
<#if table.idColumn.javaType =="java.lang.Integer">
<#assign pkJavaType = "java.lang.Long">
<#else>
<#assign pkJavaType = table.idColumn.javaType>
</#if>
<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/jsp/common/includes.jsp"%>
<link href="$\{_contextPath}/resource/css/datepicker.css"
	  rel="stylesheet" />
<link href="$\{_contextPath}/resource/css/jquery.validator.css"
	  rel="stylesheet" />
<script type="text/javascript"
		src="$\{_contextPath}/resource/js/jquery.validator.js"></script>
<script type="text/javascript"
		src="$\{_contextPath}/resource/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript"
		src="$\{_contextPath}/resource/js/i18n/jquery.validator.<fmt:message key='locale'/>.js"></script>
<script type="text/javascript"
		src="$\{_contextPath}/resource/js/i18n/datepicker/bootstrap-datepicker.<fmt:message key='locale'/>.js"></script>
<script type="text/javascript">
    $(function(){
    <@generateDateColumn/>

        $('#contentForm').validator({theme:"yellow_right"});
    });
</script>

<div class="highlight">
	<form class="form-horizontal" role="form" action="$\{_contextPath }/${modulName}/${classNameFirstLower}/$\{method}.do" id="contentForm" method="post">
		<@generateNotPkResult/>

		<div class="form-group">

			<div class="col-sm-offset-3 col-sm-1 text-right">

				<button type="submit" class="btn btn-primary">
					<fmt:message key="common.submit" />
				</button>
			</div>

			<div class="col-sm-8 text-left">
				<a href="$\{_contextPath}$\{parentUrl}" class="btn"> <fmt:message
						key="common.back" /></a>
			</div>
		</div>

	</form>
</div>

<#macro generateNotPkResult>
<#list table.columns as column>
<#if column.pk>
<c:if test="$\{not empty dataObj.id }">
	<input type="hidden" id="id" name="id"  style="width:220px;" value="$\{dataObj.id}"/>

</c:if>
<#else>
<#if column.isDateTimeColumn>
<div class="form-group ">
	<label for="${column.columnNameFirstLower}" class="col-sm-3 control-label"><fmt:message
			key="${classNameFirstLower}.${column.columnNameFirstLower}" />:<span class="red">*</span></label>
	<div class="col-sm-4">
		<input type="text" class="input-sm" name="${column.columnNameFirstLower}" id="${column.columnNameFirstLower}"
			   placeholder="<fmt:message key="${classNameFirstLower}.${column.columnNameFirstLower}.placeholder"/>" data-rule="required" style="width:220px;" value="<fmt:formatDate pattern="yyyy-MM-dd" value="$\{dataObj.${column.columnNameFirstLower} }" />">
	</div>
	<div class="col-sm-5"></div>
</div>
<#else>
<div class="form-group ">
	<label for="${column.columnNameFirstLower}" class="col-sm-3 control-label"><fmt:message
			key="${classNameFirstLower}.${column.columnNameFirstLower}" />:<span class="red">*</span></label>
	<div class="col-sm-4">
		<input type="text" class="input-sm" name="${column.columnNameFirstLower}" id="${column.columnNameFirstLower}"
			   placeholder="<fmt:message key="${classNameFirstLower}.${column.columnNameFirstLower}.placeholder"/>" data-rule="required" style="width:220px;" value="$\{dataObj.${column.columnNameFirstLower}}">
	</div>
	<div class="col-sm-5"></div>
</div>
</#if>

</#if>
</#list>
</#macro>
<#macro generateDateColumn>
<#list table.columns as column>
<#if column.isDateTimeColumn>
$('#${column.columnNameFirstLower}').datepicker({
autoclose:true,
clearBtn:true,
todayBtn:true,
todayHighlight:true,
format:"yyyy-mm-dd"
}).on("hide",function(){
$('#${column.columnNameFirstLower}').trigger("blur")
});


</#if>
</#list>
</#macro>