package com.sanders.springdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;

import com.sanders.springdemo.dao.OrganizationDao;
import com.sanders.springdemo.domain.Organization;

@Component
public class JdbcTemplateClassicApp1 {
	
	@Autowired
	private OrganizationDao dao;
	@Autowired
	private DaoUtils daoUtils;
	
	public void actionMethod() {
		
		// Create seed data
		daoUtils.createSeedData(dao);
		
		// List organizations
		try {
		List<Organization> orgs = dao.getAllOrgnizations();
		daoUtils.printOrganizations(orgs, daoUtils.readOperation);
		} catch(BadSqlGrammarException bge) {
			System.out.println("SUB EXCEPTION MESSAGE: " + bge.getMessage());
			System.out.println("SUB EXCEPTION CLASS: " + bge.getClass());
		} catch(DataAccessException dae) {
			System.out.println("EXCEPTION MESSAGE: " + dae.getMessage());
			System.out.println("EXCEPTION CLASS: " + dae.getClass());
		}
		
		//Create a new orgnization record
		Organization org = new Organization("General Electric", 1978, "98989", 5776, "Imagination at work");
		boolean isCreated = dao.create(org);
		daoUtils.printSuccessFailure(daoUtils.createOperation, isCreated);
		daoUtils.printOrganizations(dao.getAllOrgnizations(), daoUtils.readOperation);
		
		// Get a single organization
		Organization org2 = dao.getOrganization(1);
		daoUtils.printOrganization(org2, "getOrganization");
		
		//Update slogan
		Organization org3 = dao.getOrganization(2);
		org3.setSlogan("We build **awesome** driving machines" );
		boolean isUpdated = dao.update(org3);
		daoUtils.printSuccessFailure(daoUtils.updateOperation, isUpdated);
		daoUtils.printOrganization(dao.getOrganization(2), daoUtils.updateOperation);
		
		// Delete an organization
		boolean isDeleted = dao.delete(dao.getOrganization(3));
		daoUtils.printSuccessFailure(daoUtils.deleteOperation, isDeleted);
		daoUtils.printOrganizations(dao.getAllOrgnizations(), daoUtils.deleteOperation);
		
		//Cleanup
		dao.cleanup();
		daoUtils.printOrganizationCount(dao.getAllOrgnizations(), daoUtils.cleanupOperation);
	}

	public static void main(String[] args) {
		
		//create application context
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		//create the bean
//		OrganizationDao dao = (OrganizationDao) ctx.getBean("orgDao");
		JdbcTemplateClassicApp1 mainApp = ctx.getBean(JdbcTemplateClassicApp1.class);
		mainApp.actionMethod();
		
		
		
		
		//close the application context
		((ClassPathXmlApplicationContext) ctx).close();
	}

}
