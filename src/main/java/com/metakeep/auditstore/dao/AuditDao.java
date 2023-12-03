package com.metakeep.auditstore.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metakeep.auditstore.bean.AnalyticsDashboardBean;
import com.metakeep.auditstore.bean.AuditBean;
import com.metakeep.auditstore.repository.AnalyticsDashboardBeanRowMapper;


@Repository
public class AuditDao {

	private Logger logger = LoggerFactory.getLogger(AuditDao.class);

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public AuditDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void insertAuditData(AuditBean auditBean) {
		String sql = "INSERT INTO audit (user_id, request_time, status, error_message, request, response)"
				+ " VALUES (?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, auditBean.getUserId(), auditBean.getRequestTime(), 
				auditBean.getStatus(), auditBean.getErrorMessage(), auditBean.getHttpServletRequest(), 
				auditBean.getHttpServletResponse());
	}

	public AnalyticsDashboardBean retrieveAnalyticsDashboardData(String fromDate, String toDate) {
		String sql1 = "select sum(audit) as total_api_calls, sum(status) as fail_count, "
				+ "count(distinct user_id) as unique_user_count from (select 1 as audit, "
				+ "case when status = 'failure' then 1 else 0 end as status, user_id from "
				+ "public.audit where request_time between '25-11-2023' and '27-11-2023') a";

		String sql = "select sum(audit) as total_api_calls, sum(status) as fail_count, "
				+ "count(distinct user_id) as unique_user_count from (select 1 as audit, "
				+ "case when status = 'failure' then 1 else 0 end as status, user_id from "
				+ "public.audit where request_time between '"+fromDate+"' and '" +toDate+ "') a";

		System.out.println(sql);
		AnalyticsDashboardBean anlayticsDashboardData = jdbcTemplate.queryForObject(sql, new AnalyticsDashboardBeanRowMapper());

		return anlayticsDashboardData;
	}
}
