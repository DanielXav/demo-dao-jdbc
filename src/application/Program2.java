package application;

import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
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
		
		System.out.println("=== TEST 3: department insert ===");
		dep = departmentDao.findById(5);
		dep.setName("Foods");
		departmentDao.update(dep);
		System.out.println("Update completed");
	}

}
