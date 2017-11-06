package com.sanders.springdemo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sanders.springdemo.dao.OrganizationDao;
import com.sanders.springdemo.domain.Organization;

public class JdbcTemplateClassicApp1 {

	public static void main(String[] args) {
		
		//create application context
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		//create the bean
		OrganizationDao dao = (OrganizationDao) ctx.getBean("orgDao");
		
		// Create seed data
		DaoUtils.createSeedData(dao);
		
		// List organizations
		List<Organization> orgs = dao.getAllOrgnizations();
		DaoUtils.printOrganizations(orgs, DaoUtils.readOperation);
		
		//Create a new orgnization record
		Organization org = new Organization("General Electric", 1978, "98989", 5776, "Imagination at work");
		boolean isCreated = dao.create(org);
		DaoUtils.printSuccessFailure(DaoUtils.createOperation, isCreated);
		DaoUtils.printOrganizations(dao.getAllOrgnizations(), DaoUtils.readOperation);
		
		// Get a single organization
		Organization org2 = dao.getOrganization(1);
		DaoUtils.printOrganization(org2, "getOrganization");
		
		// Cleanup
		dao.cleanup();
		DaoUtils.printOrganizationCount(dao.getAllOrgnizations(), DaoUtils.cleanupOperation);
		
		
		//close the application context
		((ClassPathXmlApplicationContext) ctx).close();
	}

}
