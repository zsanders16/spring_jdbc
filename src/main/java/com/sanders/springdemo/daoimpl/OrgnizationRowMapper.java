package com.sanders.springdemo.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sanders.springdemo.domain.Organization;

public class OrgnizationRowMapper implements RowMapper<Organization> {

	public Organization mapRow(ResultSet rs, int rownum) throws SQLException {
		Organization org = new Organization();
		org.setId(rs.getInt("id"));
		org.setCompanyName(rs.getString("company_name"));
		org.setYearOfIncorporation(rs.getInt("year_of_incorporation"));
		org.setPostalCode(rs.getString("postal"));
		org.setEmployeeCount(rs.getInt("employee_count"));
		org.setSlogan(rs.getString("slogan"));
		
		return org;
	}

	
}