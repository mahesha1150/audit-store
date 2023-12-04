package com.metakeep.auditstore.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
		
		/* System.out.println(fromDateStr); */

		AnalyticsDashboardBean anlayticsDashboardData = auditDao.retrieveAnalyticsDashboardData(fromDateStr, toDateStr);

		return anlayticsDashboardData;
	}

	public String mockData() {
		List<AuditBean> auditBeansList = new ArrayList<>();
		
		for(int i = 0; i<10; i++) {
			AuditBean auditBean = new AuditBean();
			Random random = new Random();
	        int randomUserId = random.nextInt(500);
	        auditBean.setUserId(randomUserId+"");
	        boolean isEven = randomUserId %2 == 0;
	        if(isEven) {
	        	auditBean.setStatus("success");
	        	auditBean.setErrorMessage("");
	        	auditBean.setHttpServletRequest("/helloworld");
	        	auditBean.setHttpServletResponse("200");
	        }else {
	        	auditBean.setStatus("failure");
	        	auditBean.setErrorMessage("Error in the request: "+randomUserId);
	        	auditBean.setHttpServletRequest("/helloworld");
	        	auditBean.setHttpServletResponse("400");
	        }
	        
	        int daysToSubtract = random.nextInt(100);
	        System.out.println("Number of days to subtract: "+daysToSubtract);
	        
	        LocalDateTime currentDateTime = LocalDateTime.now();
	        LocalDateTime uriRequestDate = currentDateTime.minusDays(daysToSubtract);
	        Date date = java.sql.Timestamp.valueOf(uriRequestDate);
	        auditBean.setRequestTime(date);
	        
	        auditBeansList.add(auditBean);
		}
		
		String noOfUsersAdded = auditDao.mockData(auditBeansList);
		
		return noOfUsersAdded;
	}
	
}
