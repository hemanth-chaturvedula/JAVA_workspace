package com.telstra.taxpack;

import com.telstra.emppack.Employee;
import com.telstra.emppack.Manager;
import com.telstra.emppack.Programmer;

public class Tax {
	
	public  double calc_Tax(Employee emp)
	{
		 double taxAmt=0.0;
		if (emp instanceof Manager)
		{
			Manager m=(Manager) emp;
			taxAmt = 0.3*m.calcNetSal();
		}
		else
			if (emp instanceof Programmer)
			{
				Programmer e =(Programmer) emp;
				taxAmt = 0.2*e.calcNetSal();
			}
			else
			{
				taxAmt = 0.0;
			}
		
		
		return taxAmt;
	}

}
