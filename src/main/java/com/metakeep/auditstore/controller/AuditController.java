package com.metakeep.auditstore.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.metakeep.auditstore.bean.AnalyticsDashboardBean;
import com.metakeep.auditstore.bean.AuditBean;
import com.metakeep.auditstore.service.AuditService;

@RestController
@CrossOrigin(origins = "*")
public class AuditController {

	private Logger logger = LoggerFactory.getLogger(AuditController.class);
	
	@Autowired
	private AuditService auditService;
	
	@PostMapping("/audit")
	public String audit(@RequestBody AuditBean auditBean) {
		String response = "Received bean with name: " + auditBean.getUserId();
		System.out.println(response);

		auditService.auditService(auditBean);
		return response;
	}
	
	
	@GetMapping("/analytics-dashboard")
	public AnalyticsDashboardBean analyticsDashboard(@RequestParam Date fromDate, @RequestParam Date toDate) {
		System.out.println("Received parameters: param1=" + fromDate + ", param2=" + toDate);
		
		AnalyticsDashboardBean anlayticsDashboardData = auditService.retrieveAnalyticsDashboardService(fromDate, toDate);
		
		/* System.out.println(anlayticsDashboardData.getNoOfUniqueUsers()); */
		
		return anlayticsDashboardData;
	}
	
	
}
