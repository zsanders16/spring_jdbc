package com.sanders.springdemo.dao;

import java.util.List;

import javax.sql.DataSource;

import com.sanders.springdemo.domain.Organization;

public interface OrganizationDao {
	
	// Set the dats-source that will be required to create a connection to the database
	public void setDataSource(DataSource ds);
	
	// Create a record in the organization table
	public boolean create(Organization org);
	
	// Retrieve a single Organizaion
	public Organization getOrganization(Integer id);
	
	// Retrieve all orgnizaitons from table
	public List<Organization> getAllOrgnizations();
	
	// Delete specific org from table
	public boolean delete(Organization org);
	
	//Update an existing orgnization
	public boolean update(Organization org);
	
	public void cleanup();
}
