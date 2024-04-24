package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2: seller findByDepartment ===");
		Department dep = new Department(4, null);
		List<Seller> sellerList = sellerDao.findByDepartment(dep);
		for(Seller x : sellerList) {
			System.out.println(x);
		}
		
		System.out.println("\n=== TEST 3: seller findAll ===");
		sellerList = sellerDao.findAll();
		for(Seller x : sellerList) {
			System.out.println(x);
		}

		/*
		System.out.println("\n=== TEST 4: seller insert ===");
		Seller insertSeller = new Seller(null, "Mariana", "mariana@gmail.com", new Date(), 5000.0, dep);
		sellerDao.insert(insertSeller);
		System.out.println("Inserted! New id = " + insertSeller.getId());
		*/
		
		System.out.println("\n=== TEST 5: seller update ===");
		seller = sellerDao.findById(10);
		seller.setName("Pedro");
		seller.setEmail("pedro@gmail.com");
		seller.setBaseSalary(3500.0);
		seller.setDepartment(new Department(2, "Electronics"));
		sellerDao.update(seller);
		System.out.println("Updated completed! Seller updated to: " + seller);
		
	}
}