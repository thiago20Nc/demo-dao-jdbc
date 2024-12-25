package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);  
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println(" === TEST 1: department findById === ");
		Department department = departmentDao.findById(1);
		System.out.println(department);
		
		System.out.println("\n === TEST 2: department findByDepartment === "); 
		department = new Department(2, null);
		List<Department> list = departmentDao.findAll(); 
		for(Department obj : list) {
			System.out.println(obj);
		} 
		
		System.out.println("\n === TEST 3: department insert === "); 
		Department newDepartment = new Department(null, "Food"); 
		departmentDao.insert(newDepartment); 
		System.out.println("Inserted! New Id = " + newDepartment.getId()); 
		
		System.out.println("\n === TEST 4: department update === "); 
		Department department2 = departmentDao.findById(4);
		department2.setName("Cars");
		departmentDao.update(department2); 
		System.out.println("Update Completed!"); 
		
		System.out.println("\n === TEST 5: department delete === "); 
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt(); 
		departmentDao.deleteById(id); 
		System.out.println("Delete completed");
		
		sc.close();
	}
}
