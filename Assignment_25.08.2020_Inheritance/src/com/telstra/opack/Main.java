package com.telstra.opack;

import com.telstra.emppack.Employee;
import com.telstra.emppack.Manager;
import com.telstra.emppack.Programmer;

public class Main {

	public static void main(String[] args) {
		//Dynamic polymorphism 
		//Employee e1 = new Employee(100,"Porvika",60000);
		//System.out.println(e1.getDetails());
		
		Manager m1 = new Manager(200,"Sherya",70000,"HR",10);
		System.out.println(m1.getDetails());
		
		//Virtual Method Invoccation in Java
		
		Employee emp = new Manager(201,"Neil",70000,"IT",5);
		System.out.println(emp.getDetails());
		
		Manager manager = (Manager)emp;
		
		System.out.println(manager.getDeptName()+manager.getEmpCount());
		//  Hetrogeous Array due to the IS-A relationship 
		//base class ref array can hold all its derived class objects
		Employee[] emparr = new Employee[3];
		
		//emparr[0] = new Employee(101,"xxx",40000);
		emparr[0]= new Manager(202,"yyy",75000,"RD",15);
		emparr[1]= new Manager(203,"zzz",75000,"Finance",15);
		emparr[2]= new Programmer(300,"AAA",60000,3,"Java");
		
		System.out.println("Printing the details of the Employees");
		
		for (Employee emp1:emparr)
		{
			System.out.println(emp1.getDetails());
		}

	}

}
