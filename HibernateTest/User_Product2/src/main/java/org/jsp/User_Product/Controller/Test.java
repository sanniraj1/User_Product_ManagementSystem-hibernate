package org.jsp.User_Product.Controller;


import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Test {

	public static void main(String[] args) 
	{

		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		
		
	}

}
