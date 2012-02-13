<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE sqlMap PUBLIC "-//iBATIS.com//DTD SQL Map 2.0//EN" "http://www.ibatis.com/dtd/sql-map-2.dtd">

<!-- Always ensure to use the correct XML header as above! -->
<sqlMap namespace="${className}">
<typeAlias alias="<@lowerFirstChar>${className}</@lowerFirstChar>" type="${domain}"/>
<resultMap id="<@lowerFirstChar>${className}</@lowerFirstChar>_result" class="<@lowerFirstChar>${className}</@lowerFirstChar>">
	<#list columns as column>
    <result property="${column.javaName}" column="${column.columnName}"/>
    </#list>
</resultMap>

<sql id="${className}_Query_List_Sharing">
	<dynamic prepend="WHERE">
		<#list columns as column>
			<isNotEmpty prepend="and" property = "${column.javaName}">
				${column.columnName} = #${column.javaName}#
			</isNotEmpty>
		</#list>
	</dynamic>
</sql>

<sql id="${className}_List_Paramter">
	<dynamic prepend="ORDER BY">
		<isNotEmpty property = "orderItem">
			 $orderItem$ $orderType$ <!-- # and $ has difference, this place need $ -->
		</isNotEmpty>
	</dynamic>
</sql>

<sql id="${className}_column">
	<#list columns as column>
		<#if column_has_next>
			${column.columnName},
		<#else>
			${column.columnName}
		</#if>
	</#list>
</sql>

<sql id="${className}_By_Id">
	WHERE <#list columns as column> <#if column_index ==0>${column.columnName} = #${column.javaName}#<#break></#if></#list>
</sql> 

<insert id="add${className}" parameterClass="<@lowerFirstChar>${className}</@lowerFirstChar>" >
    INSERT INTO ${tableName} (
	<include refid="${className}_column" />
        )
    VALUES (
            <#list columns as column>
            	<#if column_has_next>
				#${column.javaName}#,
				<#else>
				#${column.javaName}#
				</#if>
			</#list>
    )
    <#assign firstColumn>
    <#list columns as column>
		<#if column_index ==0>${column.javaName}<#break></#if>
		</#list>
    </#assign>
    <!--<selectKey resultClass="long" keyProperty="${firstColumn?trim}">
			select last_insert_id() as ID from ${tableName} limit 1
    </selectKey>-->
</insert>  

<update id="update${className}" parameterClass="<@lowerFirstChar>${className}</@lowerFirstChar>">
    UPDATE ${tableName} 
    <dynamic prepend="set">
		<#list columns as column>
			<isNotEmpty prepend="," property = "${column.javaName}">
				${column.columnName} = #${column.javaName}#
			</isNotEmpty>
		</#list>
	</dynamic>
    <include refid="${className}_Query_List_Sharing" />
</update> 

<select id="find${className}" resultMap="<@lowerFirstChar>${className}</@lowerFirstChar>_result" parameterClass="java.util.HashMap">
    SELECT
     	<include refid="${className}_column" />      
    FROM ${tableName}
   <include refid="${className}_Query_List_Sharing" />
</select>

<select id="findById${className}" resultMap="<@lowerFirstChar>${className}</@lowerFirstChar>_result" parameterClass="java.lang.Long">
    SELECT
     	<include refid="${className}_column" />      
    FROM ${tableName}
    <include refid="${className}_By_Id" />
</select>

<select id="list${className}" resultMap="<@lowerFirstChar>${className}</@lowerFirstChar>_result" parameterClass="java.util.HashMap">
    SELECT
         <include refid="${className}_column" />  
    FROM ${tableName}
	<include refid="${className}_Query_List_Sharing" />
	<include refid="${className}_List_Paramter" />
	limit #begin#,#pageSize#
</select>


<select id="list${className}Count" resultClass="java.lang.Integer" parameterClass="java.util.HashMap">
    SELECT
		COUNT(*)
   	FROM ${tableName}
	<include refid="${className}_Query_List_Sharing" />
</select>

<delete id="del${className}" parameterClass="<@lowerFirstChar>${className}</@lowerFirstChar>">
    DELETE  FROM  ${tableName} 
    <include refid="${className}_By_Id" />
</delete>  

</sqlMap>
