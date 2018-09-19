<#assign className = table.className>   
<#assign classNameFirstLower = className?uncap_first>   
<#assign classNameLowerCase = className?lower_case>
        <#if table.idColumn.javaType =="java.lang.Integer">
        <#assign pkJavaType = "java.lang.Long">
        <#else>
        <#assign pkJavaType = table.idColumn.javaType>
        </#if>

package ${namespace}.bean.${datasourceName}.model.${modulName};


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
/**
 * Description: <${className} vo>. <br>
 * 
 * generate time:${.now}
 * 
 * @author generator-cp-web
 * @version V1.0
 */
@Data
@Entity
@Table(name = "${table.sqlName}", schema = "${jdbcSchema}")
public class ${className} implements Serializable{
	private static final long serialVersionUID = 1L;
	<#list table.columns as column>
	
	/*
	 * ${column.remarks}
	 */
<#if column.pk>
	@Id
	<#if idStrategy=="自增">
    <#if databaseType=="oracle">
    @SequenceGenerator(name = "sequenceGenerator", sequenceName = "${jdbcSchema}.${table.sequence}")
    @GeneratedValue(generator = "sequenceGenerator", strategy = GenerationType.SEQUENCE)
    </#if>
    <#if databaseType=="mysql">
    @GeneratedValue
    </#if>
	</#if>
	@Column(name="${column.sqlName}")
	private ${pkJavaType} id;

</#if>
<#if !column.pk>
	@Column(name="${column.sqlName}")
	private ${column.javaType} ${column.columnNameFirstLower};
	

</#if>
	
	
</#list>

}



