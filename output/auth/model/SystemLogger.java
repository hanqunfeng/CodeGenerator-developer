
package org.pyf.developer.bean.one.model.auth;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
/**
 * Description: <SystemLogger vo>. <br>
 * 
 * generate time:2018-10-9 15:29:49
 * 
 * @author generator-cp-web
 * @version V1.0
 */
@Data
@Entity
@Table(name = "tbl_cp_logger", schema = "cp2015db")
public class SystemLogger implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/*
	 * 主键
	 */
	@Id
    @GeneratedValue
	@Column(name="log_id")
	private java.lang.Long id;

	
	
	
	/*
	 * 客户端ID
	 */
	@Column(name="log_client_ip")
	private java.lang.String logClientIp;
	

	
	
	
	/*
	 * 请求url
	 */
	@Column(name="log_uri")
	private java.lang.String logUri;
	

	
	
	
	/*
	 * 终端请求方式,普通请求,ajax请求
	 */
	@Column(name="log_type")
	private java.lang.String logType;
	

	
	
	
	/*
	 * 请求方式method,post,get等
	 */
	@Column(name="log_method")
	private java.lang.String logMethod;
	

	
	
	
	/*
	 * 请求参数内容,json
	 */
	@Column(name="log_param_data")
	private java.lang.String logParamData;
	

	
	
	
	/*
	 * 请求接口唯一session标识
	 */
	@Column(name="log_session_id")
	private java.lang.String logSessionId;
	

	
	
	
	/*
	 * 请求时间
	 */
	@Column(name="log_time")
	private java.util.Date logTime;
	

	
	
	
	/*
	 * 接口返回时间
	 */
	@Column(name="log_returm_time")
	private java.lang.String logReturmTime;
	

	
	
	
	/*
	 * 接口返回数据json
	 */
	@Column(name="log_return_data")
	private java.lang.String logReturnData;
	

	
	
	
	/*
	 * 请求时httpStatusCode代码，如：200,400,404等
	 */
	@Column(name="log_http_status_code")
	private java.lang.String logHttpStatusCode;
	

	
	
	
	/*
	 * 请求耗时秒单位
	 */
	@Column(name="log_time_consuming")
	private java.lang.Integer logTimeConsuming;
	

	
	
	
	/*
	 * 操作内容
	 */
	@Column(name="log_desc")
	private java.lang.String logDesc;
	

	
	
	
	/*
	 * 用户名称
	 */
	@Column(name="log_user")
	private java.lang.String logUser;
	

	
	

}



