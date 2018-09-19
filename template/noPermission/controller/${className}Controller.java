<#assign className = table.className>
<#assign classNameFirstLower = className?uncap_first>
<#assign classNameLowerCase = className?lower_case>


<#if table.idColumn.javaType =="java.lang.Integer">
        <#assign pkJavaType = "java.lang.Long">
<#else>
        <#assign pkJavaType = table.idColumn.javaType>
</#if>

package ${namespace}.web.controller.${modulName};



import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import org.pyf.developer.utils.page.CP_Page;
import org.pyf.developer.utils.page.CP_Sorter;
import org.pyf.developer.web.controller.base.CP_SimpleBaseController;
import org.pyf.developer.web.utils.log.CP_GlobalNamingConstant;
import org.pyf.developer.web.utils.log.CP_OperateLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.pyf.developer.web.utils.log.CP_GlobalNamingConstant.*;
import lombok.extern.slf4j.Slf4j;


import ${namespace}.servcie.${modulName}.${className}Service;
import ${namespace}.bean.${datasourceName}.model.${modulName}.${className};


/**
 * Description: <${modulName}模块controller >. <br>
 * <p>
 * <基本的crud>
 * </p>
 * generate time:${.now}
 *
 * @author generator-cp-web
 * @version V1.0
 */

@Controller
@Slf4j
@RequestMapping("/${modulName}")
public class ${className}Controller extends CP_SimpleBaseController{


	@Resource(name = "${classNameFirstLower}Service")
	protected ${className}Service ${classNameFirstLower}Service;

	/** binder用于bean属性的设置 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	/**
	 * ${table.remarks}管理列表页.
	 *
	 * @param ${classNameFirstLower}
	 *
	 * @param model
	 *
	 * @return list.jsp
	 */
	@RequestMapping("/${classNameFirstLower}/list.do")
	@CP_OperateLog(value="${table.remarks}列表",type=OPERATE_LIST)
	public String handleList(@ModelAttribute("queryBean") ${className} ${classNameFirstLower}, Model model,@ModelAttribute("_pageBean") CP_Page page,
			@ModelAttribute("sorter") CP_Sorter sorter) {
		log.info("[${className}Controller:handleList][begin]");
		log.info("UID====" + CP_AuthenticationUtils.getUsername());

		if ( sorter.getSortName() == null
		|| "".equals(sorter.getSortName())) {
            sorter.setSortName("id");
            sorter.setSortType(CP_Sorter.DESC);
		}

		List<${className}> 	results = ${classNameFirstLower}Service.findByPage(page,sorter,${classNameFirstLower});
			model.addAttribute("results", results);
			log.info("[${className}Controller:handleList][end]");
		return "${classNameFirstLower}_list_view";

	}
	/**
	 *
	* 描述 : <新增/编辑${table.remarks}页面>. <br>
	*<p>

	* @param ${classNameFirstLower}
	* @param model
	* @return
	 */
	@RequestMapping("/${classNameFirstLower}/edit.do")
	@CP_OperateLog(value = "新增/编辑${table.remarks}页面", type = OPERATE_ADD)
	public String handleEdit(${className} ${classNameFirstLower},Model model) {
		log.info("[${className}Controller:handleEdit][begin]");
		log.info("UID====" + CP_AuthenticationUtils.getUsername());
		<#if pkJavaType =="java.lang.Long" || pkJavaType =="java.lang.Integer">
		if(${classNameFirstLower}.getId()!=null){
		</#if>
		<#if pkJavaType =="java.lang.String">
		if(StringUtils.isNoneBlank(${classNameFirstLower}.getId())){
		</#if>
			${classNameFirstLower} = ${classNameFirstLower}Service.findById(${classNameFirstLower}.getId());
			model.addAttribute("method","update");
		}else{
			model.addAttribute("method","add");
		}
		model.addAttribute("dataObj",${classNameFirstLower});
		log.info("[${className}Controller:handleEdit][end]");
		return "${classNameFirstLower}_edit_view";
	}
	/**
	 *
	* 描述 : 更新${table.remarks}操作>. <br>
	*<p>

	* @param ${classNameFirstLower}
	* @param model
	* @return
	 */
	@RequestMapping("/${classNameFirstLower}/update.do")
	@CP_OperateLog(value = "保存${table.remarks}", type = OPERATE_ADD)
	public String handleUpdate(@ModelAttribute("dataObj") ${className} ${classNameFirstLower},Model model) {
		log.info("[${className}Controller:handleUpdate][begin]");
		log.info("UID====" + CP_AuthenticationUtils.getUsername());
		model.addAttribute("method", "update");
		try{
			${classNameFirstLower}Service.update(${classNameFirstLower});
		}catch(Exception e){
			model.addAttribute("dataObj",${classNameFirstLower});
			log.error(e.getMessage());
			model.addAttribute("messageSattus","error");
			model.addAttribute("message","message.operation.failed");
			return "${classNameFirstLower}_edit_view";
		}
		model.addAttribute("message","message.operation.success");
		log.info("[${className}Controller:handleUpdate][end]");
		return "${classNameFirstLower}_edit_view";
	}

	/**
	 *
	* 描述 : 新增${table.remarks}操作>. <br>
	*<p>

	* @param ${classNameFirstLower}
	* @param model
	* @param redirectAttrs
	* @return
	 */
	@RequestMapping("/${classNameFirstLower}/add.do")
	@CP_OperateLog(value="新增${table.remarks}",type=OPERATE_ADD)
	public String handleAdd(@ModelAttribute("dataObj") ${className} ${classNameFirstLower}, Model model,RedirectAttributes redirectAttrs) {
		log.info("[${className}Controller:handleAdd][begin]");
		log.info("UID====" + CP_AuthenticationUtils.getUsername());

		try{
			${classNameFirstLower}Service.add(${classNameFirstLower});
			model.addAttribute("method", "update");
		}catch(Exception e){
			model.addAttribute("method", "add");
			log.error(e.getMessage());
			model.addAttribute("messageSattus","error");
			model.addAttribute("message","message.operation.failed");
			return "${classNameFirstLower}_edit_view";
		}
		redirectAttrs.addFlashAttribute("message","message.operation.success");
		log.info("[${className}Controller:handleAdd][end]");
		return "redirect:/${classNameFirstLower}/edit.do?id="+${classNameFirstLower}.getId();
	}

	/**
	 * 删除功能${table.remarks}
	 *
	 * @param ids
	 *            id数组
	 * @param model
	 *            数据封装
	 * @return 视图名称
	 */
	@RequestMapping("/${classNameFirstLower}/delete.do")
	@CP_OperateLog(value = "删除${table.remarks}", type = OPERATE_DELETE)
	public String handleDelete(${pkJavaType}[] ids, Model model,RedirectAttributes redirectAttrs) {
		log.info("[${className}Controller:handleDelete][begin]");
		log.info("UID====" + CP_AuthenticationUtils.getUsername());
		try{
			${classNameFirstLower}Service.delete(ids);
		}catch(Exception e){
			log.error(e.getMessage());
			redirectAttrs.addFlashAttribute("messageSattus","error");
			redirectAttrs.addFlashAttribute("message","message.operation.failed");
		}
		redirectAttrs.addFlashAttribute("message","message.operation.success");
		log.info("[${className}Controller:handleDelete][end]");
		return "redirect:/${classNameFirstLower}/list.do";
	}

}

