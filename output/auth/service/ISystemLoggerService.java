package org.pyf.developer.service.auth;import org.pyf.developer.bean.one.model.auth.SystemLogger;import org.pyf.developer.utils.page.CP_Page;import org.pyf.developer.utils.page.CP_Sorter;import java.util.List;/** * Description: <systemLoggerservice>. <br> * <p> * <service接口层> * </p> * generate time:2018-10-9 15:29:49 *  * @author generator-cp-web * @version V1.0 */public interface ISystemLoggerService {/**	 * 描述 : <SystemLogger列表:查询>. <br>	 * <p>	 * 	 * @param systemLogger	 *	 * @param sorter	 *	 * @param page	 *	 * @return List<SystemLogger>	 */	public List<SystemLogger> findByPage(CP_Page page,CP_Sorter sorter,SystemLogger systemLogger,String... fields);	/**	 * 	* 描述 : <更新SystemLogger.>. <br>  	*<p>                                                   	* @param systemLogger	 * @throws Exception 	 */	public SystemLogger update(SystemLogger systemLogger);		/**	 * 	 * 描述 : <新增SystemLogger.>. <br>  	 *<p>                                                   	 * @param systemLogger	 * @throws Exception 	 */	public SystemLogger add(SystemLogger systemLogger);		/**	 * 	* 描述 : <根据id查询SystemLogger>. <br>  	*<p>                                                   	* @param id	* @return	 */	public SystemLogger findById(java.lang.Long id,String... fields);		/**	 * 	* 描述 : <根据id删除SystemLogger>. <br>  	*<p>                                                   	* @param ids	* @return	 */	public void delete(java.lang.Long... ids);	}