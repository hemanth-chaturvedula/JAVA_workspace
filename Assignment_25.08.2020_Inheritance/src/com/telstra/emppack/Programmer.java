package com.telstra.emppack;

public class Programmer extends Employee{
	private int noOfProjects;
	private String skillset;
	
	
	
	public Programmer(int empId, String empName, int bSal, int noOfProjects,
			String skillset) {
		super(empId, empName, bSal);
		this.noOfProjects = noOfProjects;
		this.skillset = skillset;
	}
	
	public String getDetails()
	{
		return super.getDetails()+"  "+noOfProjects+"   "+skillset;
	}

	@Override
	public double calcNetSal() {
		// TODO Auto-generated method stub
		return 100000.0;
	}

}
