


package org.pyf.developer.web.controller.auth;



import lombok.extern.slf4j.Slf4j;
import org.pyf.developer.bean.one.model.auth.SystemLogger;
import org.pyf.developer.servcie.auth.SystemLoggerService;
import org.pyf.developer.utils.page.CP_Page;
import org.pyf.developer.utils.page.CP_Sorter;
import org.pyf.developer.web.controller.base.CP_SimpleBaseController;
import org.pyf.developer.web.utils.log.CP_OperateLog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.pyf.developer.web.utils.log.CP_GlobalNamingConstant.*;


/**
 * Description: <auth模块controller >. <br>
 * <p>
 * <基本的crud>
 * </p>
 * generate time:2018-10-9 15:29:48
 *
 * @author generator-cp-web
 * @version V1.0
 */

@Controller
@Slf4j
@RequestMapping("/auth")
public class SystemLoggerController extends CP_SimpleBaseController{


	@Resource(name = "systemLoggerService")
	protected SystemLoggerService systemLoggerService;

	/** binder用于bean属性的设置 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	/**
	 * 管理列表页.
	 *
	 * @param systemLogger
	 *
	 * @param model
	 *
	 * @return list.jsp
	 */
	@RequestMapping("/systemLogger/list.do")
	@CP_OperateLog(value="列表",type=OPERATE_LIST)
	public String handleList(@ModelAttribute("queryBean") SystemLogger systemLogger, Model model,@ModelAttribute("_pageBean") CP_Page page,
			@ModelAttribute("sorter") CP_Sorter sorter) {
		log.info("[SystemLoggerController:handleList][begin]");
		log.info("UID====" + CP_AuthenticationUtils.getUsername());

		if ( sorter.getSortName() == null
		|| "".equals(sorter.getSortName())) {
            sorter.setSortName("id");
            sorter.setSortType(CP_Sorter.DESC);
		}

		List<SystemLogger> 	results = systemLoggerService.findByPage(page,sorter,systemLogger);
			model.addAttribute("results", results);
			log.info("[SystemLoggerController:handleList][end]");
		return getView("systemLogger_list_view");

	}
	/**
	 *
	* 描述 : <新增/编辑页面>. <br>
	*<p>

	* @param systemLogger
	* @param model
	* @return
	 */
	@RequestMapping("/systemLogger/edit.do")
	@CP_OperateLog(value = "新增/编辑页面", type = OPERATE_ADD)
	public String handleEdit(SystemLogger systemLogger,Model model) {
		log.info("[SystemLoggerController:handleEdit][begin]");
		log.info("UID====" + CP_AuthenticationUtils.getUsername());
		if(systemLogger.getId()!=null){
			systemLogger = systemLoggerService.findById(systemLogger.getId());
			model.addAttribute("method","update");
		}else{
			model.addAttribute("method","add");
		}
		model.addAttribute("dataObj",systemLogger);
		log.info("[SystemLoggerController:handleEdit][end]");
		return getView("systemLogger_edit_view");
	}
	/**
	 *
	* 描述 : 更新操作>. <br>
	*<p>

	* @param systemLogger
	* @param model
	* @return
	 */
	@RequestMapping("/systemLogger/update.do")
	@CP_OperateLog(value = "保存", type = OPERATE_ADD)
	public String handleUpdate(@ModelAttribute("dataObj") SystemLogger systemLogger,Model model) {
		log.info("[SystemLoggerController:handleUpdate][begin]");
		log.info("UID====" + CP_AuthenticationUtils.getUsername());
		model.addAttribute("method", "update");
		try{
			systemLoggerService.update(systemLogger);
		}catch(Exception e){
			model.addAttribute("dataObj",systemLogger);
			log.error(e.getMessage());
			model.addAttribute("messageSattus","error");
			model.addAttribute("message","message.operation.failed");
			return getView("systemLogger_edit_view");
		}
		model.addAttribute("message","message.operation.success");
		log.info("[SystemLoggerController:handleUpdate][end]");
		return getView("systemLogger_edit_view");
	}

	/**
	 *
	* 描述 : 新增操作>. <br>
	*<p>

	* @param systemLogger
	* @param model
	* @param redirectAttrs
	* @return
	 */
	@RequestMapping("/systemLogger/add.do")
	@CP_OperateLog(value="新增",type=OPERATE_ADD)
	public String handleAdd(@ModelAttribute("dataObj") SystemLogger systemLogger, Model model,RedirectAttributes redirectAttrs) {
		log.info("[SystemLoggerController:handleAdd][begin]");
		log.info("UID====" + CP_AuthenticationUtils.getUsername());

		try{
			systemLoggerService.add(systemLogger);
			model.addAttribute("method", "update");
		}catch(Exception e){
			model.addAttribute("method", "add");
			log.error(e.getMessage());
			model.addAttribute("messageSattus","error");
			model.addAttribute("message","message.operation.failed");
			return getView("systemLogger_edit_view");
		}
		redirectAttrs.addFlashAttribute("message","message.operation.success");
		log.info("[SystemLoggerController:handleAdd][end]");
		return "redirect:/auth/systemLogger/edit.do?id="+systemLogger.getId();
	}

	/**
	 * 删除功能
	 *
	 * @param ids
	 *            id数组
	 * @param model
	 *            数据封装
	 * @return 视图名称
	 */
	@RequestMapping("/systemLogger/delete.do")
	@CP_OperateLog(value = "删除", type = OPERATE_DELETE)
	public String handleDelete(java.lang.Long[] ids, Model model,RedirectAttributes redirectAttrs) {
		log.info("[SystemLoggerController:handleDelete][begin]");
		log.info("UID====" + CP_AuthenticationUtils.getUsername());
		try{
			systemLoggerService.delete(ids);
		}catch(Exception e){
			log.error(e.getMessage());
			redirectAttrs.addFlashAttribute("messageSattus","error");
			redirectAttrs.addFlashAttribute("message","message.operation.failed");
		}
		redirectAttrs.addFlashAttribute("message","message.operation.success");
		log.info("[SystemLoggerController:handleDelete][end]");
		return "redirect:/auth/systemLogger/list.do";
	}

}

