package app;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DAOFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SellerDAO sellerDao = DAOFactory.createSellerDAO();
		
		System.out.println("-----TESTE 1: seller findById-----");
		
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n-----TESTE 2: seller findByDepartment-----");
		Department department = new Department(2,null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n-----TESTE 3: seller findAll-----");
		list = sellerDao.findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n-----TESTE 4: seller INSERT-----");
		Seller newSeller = new Seller(null,"Greg","greg@gmail.com",new Date(),4000.0, department);
		sellerDao.insert(newSeller);

	    System.out.println("Inserted. Novo id igual a " + newSeller.getId());
	    
		System.out.println("\n-----TESTE 5: seller UPDATE-----");
		seller = sellerDao.findById(1);
		seller.setName("Enio Quadros");
		sellerDao.update(seller);

	    System.out.println("Updated completed");
	    
		System.out.println("\n-----TESTE 6: seller DELETE-----");
		System.out.println("Entre com id");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
	    System.out.println("Delete completed");
	    
	    sc.close();
	}
}
