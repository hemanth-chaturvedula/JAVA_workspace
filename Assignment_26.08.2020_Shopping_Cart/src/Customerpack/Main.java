package Customerpack;

import java.util.ArrayList;
import java.util.Scanner;

import prodaccesspack.ProductAccess;
import prodpack.Product;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Assuming customer already logged in
		while(true){
			
			System.out.println("1. List of all products");
			System.out.println("2. Add  a product to the cart by ID");
			System.out.println("3. Remove a product from the cart by ID");
			System.out.println("4. ViewCart");
			System.out.println("5. Exit"); 
			System.out.println("Enter your choice");
			int choice = sc.nextInt();
			switch(choice){
			case 1:
			{
								
				break;
			
			}
			case 2: 
			{
				
				
				break;
			}
			case 3:
			{
				break;
			}
			case 4:
			{
				break;
			}
		
			case 5:
			{	
				sc.close();
				System.exit(0);
			}
			
		}
		
	}
	
	

	}
}
