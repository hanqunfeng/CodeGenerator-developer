package org.pyf.developer.service.auth;import com.querydsl.core.types.dsl.BooleanExpression;import lombok.extern.slf4j.Slf4j;import org.apache.commons.collections4.IteratorUtils;import org.apache.commons.lang3.ArrayUtils;import org.pyf.developer.bean.one.model.auth.QSystemLogger;import org.pyf.developer.bean.one.model.auth.SystemLogger;import org.pyf.developer.dao.jpa.one.auth.SystemLoggerJpaRepository;import org.pyf.developer.utils.page.CP_Page;import org.pyf.developer.utils.page.CP_Sorter;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.cache.annotation.CacheConfig;import org.springframework.data.domain.Page;import org.springframework.data.domain.PageRequest;import org.springframework.data.domain.Pageable;import org.springframework.data.domain.Sort;import org.springframework.stereotype.Service;import javax.transaction.Transactional;import java.util.ArrayList;import java.util.Iterator;import java.util.List;import java.util.UUID;/** * Description: <systemLoggerServiceImpl>. <br> * <p> * <systemLoggerservice实现类> * </p> * generate time:2018-10-9 15:29:49 *  * @author generator-cp-web * @version V1.0 */@Service(value="systemLoggerService")@Slf4j@CacheConfig(cacheNames = "commonCache")@Transactionalpublic class SystemLoggerServiceImpl implements		ISystemLoggerService {    @Autowired    SystemLoggerJpaRepository systemLoggerJpaRepository;		@SuppressWarnings("unchecked")	@Override	public List<SystemLogger> findByPage(CP_Page page, CP_Sorter sorter, SystemLogger systemLogger,String... fields) {		log.info("分页查询SystemLogger列表begin");		log.info("SystemLoggerServiceImpl findByPage begin");        page.setPageSize(25);        //排序        Sort sort = new Sort(sorter.getSortType().equals(CP_Sorter.DESC) ? Sort.Direction.DESC : Sort.Direction.ASC, sorter.getSortName());        //分页        Pageable pageable = PageRequest.of(page.getIndex(), page.getPageSize(), sort);        QSystemLogger qSystemLogger = QSystemLogger.systemLogger;        List<BooleanExpression> predicateList = new ArrayList<>();        if(systemLogger.getId()!=null)            predicateList.add(qSystemLogger.id.eq(systemLogger.getId() ));        Page<SystemLogger> resultPage = systemLoggerJpaRepository.findAll(predicateList, pageable);        page.setTotal(resultPage.getTotalElements());        //如有需要，可以转成list        List<SystemLogger> results = IteratorUtils.toList(resultPage.iterator());		log.info("分页查询SystemLogger列表end");		log.info("SystemLoggerServiceImpl findByPage end");		return results;	}	@Override	public SystemLogger update(SystemLogger systemLogger){		log.info("SystemLoggerServiceImpl update begin");        systemLoggerJpaRepository.save(systemLogger);		log.info("SystemLoggerServiceImpl update end");	return systemLogger;	}	@Override	public SystemLogger add(SystemLogger systemLogger){		log.info("SystemLoggerServiceImpl add begin");		systemLogger.setId(UUID.randomUUID().toString());        systemLoggerJpaRepository.save(systemLogger);		log.info("SystemLoggerServiceImpl add begin");		return systemLogger;	}	@Override	public SystemLogger findById(java.lang.Long id ,String... fields) {		log.info("SystemLoggerServiceImpl findById begin");        SystemLogger systemLogger = systemLoggerJpaRepository.findById(Long.valueOf(id)).get()		log.info("SystemLoggerServiceImpl findById end");		return systemLogger;	}	@Override	public void delete(java.lang.Long... ids) {		log.info("SystemLoggerServiceImpl delete begin");		if (ArrayUtils.isEmpty(ids))			return;        QSystemLogger qSystemLogger = QSystemLogger.systemLogger;        //封装查询条件        BooleanExpression booleanExpression = qSystemLogger.id.in(ids);        Iterator<SystemLogger> iterator = systemLoggerJpaRepository.findAll(booleanExpression).iterator();        //如有需要，可以转成list        List<SystemLogger> results = IteratorUtils.toList(iterator);        // 删除记录        systemLoggerJpaRepository.deleteAll(results);		log.info("SystemLoggerServiceImpl delete end");	}}