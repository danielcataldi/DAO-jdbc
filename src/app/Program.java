package app;

import java.util.Date;

import model.dao.DAOFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Department obj = new Department(1,"Books");
		System.out.println(obj);
		
		Seller seller = new Seller(21, "Bob", "bob@gmail", new Date(), 3000.0, obj);
		
		SellerDAO sellerDao = DAOFactory.createSellerDAO();

		System.out.println(seller);
	}
}
