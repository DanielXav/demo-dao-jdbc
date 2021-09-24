package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: department findById ===");
		Department dep = departmentDao.findById(2);
		System.out.println(dep);
		
		System.out.println("=== TEST 2: department findAll ===");
		List<Department> list = new ArrayList<>();
		
		list = departmentDao.findAll();
		
		for (Department x : list) {
			System.out.println(x);
		}
		
		System.out.println("=== TEST 3: department insert ===");
		dep = new Department(null, "Desktops");
		departmentDao.insert(dep);
		System.out.println("Inserted! new id = " + dep.getId());
		
		System.out.println("=== TEST 4: department update ===");
		dep = departmentDao.findById(5);
		dep.setName("Foods");
		departmentDao.update(dep);
		System.out.println("Update completed");
		
		System.out.println("=== TEST 4: department delete ===");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
	}

}
