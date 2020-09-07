package com.telstra.emppack;
// is-A Relationship with Employee
public class Manager  extends Employee{
	private String deptName;
	private int empCount;
	
	// Constructor chaining  super()
	public Manager(int empId, String empName, int bSal, String deptName,
			int empCount) {
		super(empId, empName, bSal);
		this.deptName = deptName;
		this.empCount = empCount;
		
	}
	
	// function overidding 
	@Override
	public String getDetails()
	{
		return (super.getDetails()+"  "+deptName+"  "+empCount);
	}

	public String getDeptName() {
		return deptName;
	}

	public int getEmpCount() {
		return empCount;
	}

	@Override
	public double calcNetSal() {
		// TODO Auto-generated method stub
		return 150000.0;
	}
	
	
	
	
	
	
	

}
