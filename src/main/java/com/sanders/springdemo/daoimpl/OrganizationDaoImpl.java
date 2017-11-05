package com.sanders.springdemo.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import com.sanders.springdemo.dao.OrganizationDao;
import com.sanders.springdemo.domain.Organization;

public class OrganizationDaoImpl implements OrganizationDao {

	public void setDataSource(DataSource ds) {
		// TODO Auto-generated method stub

	}

	public boolean create(Organization org) {
		// TODO Auto-generated method stub
		return false;
	}

	public Organization getOrganization(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Organization> getAllOrgnizations() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delete(Organization org) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(Organization org) {
		// TODO Auto-generated method stub
		return false;
	}

	public void cleanup() {
		// TODO Auto-generated method stub

	}

}
