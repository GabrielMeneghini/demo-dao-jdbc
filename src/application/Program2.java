package application;

import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: department findById ===");
		Department findById = departmentDao.findById(2);
		System.out.println(findById);
		
		System.out.println("\n=== TEST 2: department findAll ===");
		System.out.println(departmentDao.findAll());
		
		System.out.println("\n=== TEST 3: department insert ===");
		departmentDao.insert(new Department(null, "Kitchen Gadgets"));
		System.out.println("Insertion completed!");
		
		System.out.println("\n=== TEST 4: department update ===");
		Department dep = new Department(8, "Cables");
		departmentDao.update(dep);
		System.out.println("Update completed! Department updated to: " + dep);
		
		System.out.println("\n=== TEST 5: department delete ===");
		System.out.print("Type department id for deletion: ");
		int id = sc.nextInt();
		dep = departmentDao.findById(id);
		if(dep == null) {
			System.out.println("Deletion failed! Id does not exist.");
		} else {
			departmentDao.deleteById(id);
			System.out.println("Deletion completed! Deleted department: " + dep);
		}
		
		sc.close();
	}
}