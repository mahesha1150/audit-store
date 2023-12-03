package com.metakeep.auditstore.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metakeep.auditstore.bean.AnalyticsDashboardBean;
import com.metakeep.auditstore.bean.AuditBean;
import com.metakeep.auditstore.dao.AuditDao;

@Service
public class AuditService {

	private Logger logger = LoggerFactory.getLogger(AuditService.class);

	private AuditDao auditDao;

	@Autowired
	public AuditService(AuditDao auditDao) {
		this.auditDao = auditDao;
	}



	public String auditService(AuditBean auditBean) {

		auditDao.insertAuditData(auditBean);

		return null;
	}

	public AnalyticsDashboardBean retrieveAnalyticsDashboardService(Date fromDate, Date toDate) {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		String fromDateStr = dateFormat.format(fromDate);
		String toDateStr = dateFormat.format(toDate);
		
		System.out.println(fromDateStr);

		AnalyticsDashboardBean anlayticsDashboardData = auditDao.retrieveAnalyticsDashboardData(fromDateStr, toDateStr);

		return anlayticsDashboardData;
	}

}
