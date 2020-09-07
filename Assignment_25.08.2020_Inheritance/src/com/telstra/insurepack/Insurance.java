package com.telstra.insurepack;

import com.telstra.emppack.Employee;
import com.telstra.emppack.Manager;
import com.telstra.emppack.Programmer;

public class Insurance {
	
	public  double calc_Insurance(Employee emp)
	{
		 double insAmt=0.0;
		if (emp instanceof Manager)
		{
			Manager m=(Manager) emp;
			insAmt = 0.25*m.calcNetSal();
		}
		else
			if (emp instanceof Programmer)
			{
				Programmer e =(Programmer) emp;
				insAmt = 0.125*e.calcNetSal();
			}
			else
			{
				insAmt = 0.0;
			}
		
		
		return insAmt;
	}

}
