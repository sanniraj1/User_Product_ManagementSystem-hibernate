package org.jsp.User_Product.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.User_Product.Dto.Product;

public class ProductDao 
{
	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	
	public Product saveProduct(Product p)
	{
		manager.persist(p);
		transaction.begin();
		transaction.commit();
		return p;
		
	}
	public Product ViewProduct(int id)
	{
		String qry="select p from Product p where p.usr.id=?1";
		Query q=manager.createQuery(qry);
		q.setParameter(1,id);
		try
		{
			return (Product) q.getSingleResult();
			
		}
		catch(NoResultException e)
		{
			return null;
		}
				
		
	}
	

}
