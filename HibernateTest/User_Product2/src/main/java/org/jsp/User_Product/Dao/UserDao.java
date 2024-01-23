package org.jsp.User_Product.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.User_Product.Dto.User;

import com.mysql.cj.Query;

public class UserDao
{
	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	
	public User saveUser(User u)
	{
		manager.persist(u);
		transaction.begin();
		transaction.commit();
		return u;
		
	}
	public User updateUser(User u)
	{
		manager.merge(u);
		transaction.begin();
		transaction.commit();
		return u;
	}
	
	public User verifyUser(long phone,String password)
	{
		String qry="select u from User u where u.phone=?1 and u.password=?2";
		 q=manager.createQuery(qry);
		q.setParameter(1,phone);
		q.setParameter(1,password);
		try
		{
			return (User) q
		}
	}

}
