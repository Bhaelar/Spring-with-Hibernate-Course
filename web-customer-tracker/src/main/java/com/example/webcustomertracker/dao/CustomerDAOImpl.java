package com.example.webcustomertracker.dao;

import java.util.List;


import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.webcustomertracker.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		// get the current hibernate session
		sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Customer.class)
				.buildSessionFactory();
		
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.beginTransaction();
		// create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		currentSession.getTransaction().commit();
		
		//return the results
		 /* 
		List<Customer> customers = new ArrayList<Customer>(); 
	    Session session = sessionFactory.openSession();
	    for (Object oneObject : session.createQuery("FROM Customer").getResultList()) {
	        customers.add((Customer)oneObject);
	    }
	    System.out.println(customers.toString());
	    session.close();
	    */
		return customers;
	}

}
