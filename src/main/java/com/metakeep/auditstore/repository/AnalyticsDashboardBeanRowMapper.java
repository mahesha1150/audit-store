package com.metakeep.auditstore.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metakeep.auditstore.bean.AnalyticsDashboardBean;

public class AnalyticsDashboardBeanRowMapper implements RowMapper<AnalyticsDashboardBean>{

	@Override
	public AnalyticsDashboardBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		AnalyticsDashboardBean analyticsDashboardBean = new AnalyticsDashboardBean();
		analyticsDashboardBean.setNoOfUniqueUsers(rs.getInt("unique_user_count"));
		analyticsDashboardBean.setNoOfAPICalls(rs.getInt("total_api_calls"));
		analyticsDashboardBean.setNoOfFailures(rs.getInt("fail_count"));
		
		return analyticsDashboardBean;
	}
	
	
}
