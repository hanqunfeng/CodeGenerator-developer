<#if table.idColumn.javaType =="java.lang.Integer">
        <#assign pkJavaType = "java.lang.Long">
        <#else>
        <#assign pkJavaType = table.idColumn.javaType>
        </#if>
package ${namespace}.dao.jpa.${datasourceName}.${modulName};

import org.pyf.developer.dao.jpa.base.BaseJpaRepository;


import ${namespace}.bean.${datasourceName}.model.${modulName}.${className};


public interface ${className}JpaRepository extends BaseJpaRepository<${className},${pkJavaType}>{
}
