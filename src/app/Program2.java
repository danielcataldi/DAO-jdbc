package app;

import java.util.List;
import java.util.Scanner;

import model.dao.DAOFactory;
import model.dao.DepartmentDAO;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDAO departmentDAO = DAOFactory.createDepartmentDAO();

		System.out.println("-----TESTE 1: dep findById-----");
		Department department = departmentDAO.findById(4);
		System.out.println(department);
		
		System.out.println("\n-----TESTE 2: dep findAll-----");
	    List<Department> list = departmentDAO.findAll();		
		for(Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n-----TESTE 4: dep INSERT-----");
		Department dep = new Department(7, "Music");
		departmentDAO.insert(dep);
		System.out.println("Inserted. Novo id igual a " + dep.getId());
		
		System.out.println("\n-----TESTE 5: dep UPDATE-----");
		Department dep2 = departmentDAO.findById(4);
		dep2.setName("Musique");
	    departmentDAO.update(dep2);
		System.out.println("Update completed");
		
		System.out.println("\n-----TESTE 6: dep DELETE-----");
		System.out.println("Entre com id");
		int id = sc.nextInt();
		departmentDAO.deleteById(id);
	    System.out.println("Delete completed");
		
		sc.close();
	}
}
