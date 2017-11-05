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
		List<Organization> orgs = dao.getAllOrgnizations();
		for(Organization org : orgs) {
			System.out.println(org);
		}
		
		//close the application context
		((ClassPathXmlApplicationContext) ctx).close();
	}

}
