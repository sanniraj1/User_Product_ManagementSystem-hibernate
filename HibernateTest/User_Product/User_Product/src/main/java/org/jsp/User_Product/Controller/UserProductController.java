package org.jsp.User_Product.Controller;

import java.util.Scanner;

import org.jsp.User_Product.Dao.ProductDao;
import org.jsp.User_Product.Dao.UserDao;
import org.jsp.User_Product.Dto.Product;
import org.jsp.User_Product.Dto.User;

public class UserProductController {

	static UserDao ud=new UserDao();
	static ProductDao pd=new ProductDao ();
	static Scanner sc=new Scanner(System.in);

	public static void main(String[] args)
	{
		System.out.println("1.Save the User");
		System.out.println("2.Update the User");
		System.out.println("3.verify the User by phone and password");
		System.out.println("4.verify the User by email and password");
		System.out.println("5.Save product");
		System.out.println("6.verify product by user id");
		System.out.println("7.verify product by user phone and password");



		
		int choice =sc.nextInt();
		switch(choice)
		{
		case 1:
		{
			saveUser();
			break;
			
		}
		case 2:
		{
			updateUser();
			break;
		}
		case 3:
		{ 
			verifyUserByPhoneAndPassword();
			break;
	
		}
		case 4:
		{ 
			verifUserByEmailAndPassword();
			break;
	
		}
		case 5:
		{
			saveProduct();
			break;
			
		}
		case 6:
		{
			viewProductByUserId();
			break;
		}
		case 7:
		{
			viewProductByUserId();
			break;
		}
		}
		
	}
	public static void saveUser()
	{

		System.out.println("Enter the name,phone,email,password");
		String name=sc.next();
		long phone=sc.nextLong();
		String email=sc.next();
		String password=sc.next();
		User u=new User();
		u.setName(name);
		u.setPhone(phone);
		u.setEmail(email);
		u.setPassword(password);
		u=ud.saveUser(u);
		System.out.println("User saved with id: "+ u.getId());
		
	}
	public static void updateUser()
	{
		System.out.println("Enter the department id to update");
		int id=sc.nextInt();
		System.out.println("Enter the name,phone,email,password");
		String name=sc.next();
		long phone=sc.nextLong();
		String email=sc.next();
		String password=sc.next();
		User u=new User();
		u.setId(id);
		u.setName(name);
		u.setPhone(phone);
		u.setEmail(email);
		u.setPassword(password);
		u=ud.updateUser(u);
		System.out.println("User update with id: "+ u.getId());
	}
	public static void verifyUserByPhoneAndPassword()
	{
		System.out.println("Enter phone And Password");
		long phone=sc.nextLong();
		String password=sc.next();
		User u=ud.verifyUser(phone, password);
		
		if(u!=null)
		{
			System.out.println("name"+u.getName());
			System.out.println("phone "+u.getPhone());
			System.out.println("email "+u.getEmail());
			System.out.println("pasword:"+u.getPassword());
		}
		else
		{
			System.err.println("invalid phone and password");
		}
	}
	public static void verifUserByEmailAndPassword()
	{
		System.out.println("enter email and password");
		String email=sc.next();
		String password=sc.next();
		User u=ud.VerifyUser(email, password);
		if(u!=null)
		{
			System.out.println("name"+u.getName());
			System.out.println("phone "+u.getPhone());
			System.out.println("email "+u.getEmail());
			System.out.println("pasword:"+u.getPassword());
		}
		else
		{
			System.out.println("invalid");
		}
	}
	public static void saveProduct()
	{
		System.out.println("Enter name, description,brand,category,price");
		 String name=sc.next();
		 String description=sc.next();
		 String brand=sc.next();
		 String category=sc.next();
		 double price=sc.nextDouble();
		 Product p=new Product();
		 p.setName(name);
		 p.setDescription(description);
		 p.setBrand(brand);
		 p.setCategory(category);
		 p.setPrice(price);
		 p=pd.saveProduct(p);
		 System.out.println("product saved with "+p.getId());
	}
	public static void viewProductByUserId()
	{
		System.out.println("enter user id");
		int id=sc.nextInt();
		Product p=pd.ViewProduct(id);
		if(p!=null)
		{
			System.out.println("name: "+p.getName());
			System.out.println("descripton:"+p.getDescription());
			System.out.println("brand:"+p.getBrand());
			System.out.println("category: "+p.getCategory());
			System.out.println("price:"+p.getPrice());

		}
		else
		{
			System.err.println("invalid");
		}
	}

}
