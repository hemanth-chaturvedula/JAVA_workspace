package Customerpack;

import java.util.HashMap;
import prodpack.Product;
import prodaccesspack.ProductAccess;


public class Customer {
	//Assuming that customer already logged in, maintaining other info of customers
	//Assuming that paob is developed by admin and available to all Customers by having common database
	private int CID;
	private HashMap<Product, Integer> Cart;
	static public ProductAccess paob;
	
	static {
		//adds elements from common database
		paob = new ProductAccess();
		paob.addProduct(new Product(1, "Chocolate", 100));
		paob.addProduct(new Product(2, "Dark_chocolate", 200));
		paob.addProduct(new Product(3, "Milk_Chocolate", 150));
	}
	
	public Customer(int cID) {
		super();
		CID = cID;
		Cart = new HashMap<Product, Integer>();
	}
	
	@Override
	public String toString() {
		return "Customer [CID=" + CID + ", Cart=" + Cart + "]";
	}

	public boolean addProductCartbyID(int id,int q) {
		//this.Cart.computeIfAbsent(id, (key,val)->val+1);
		for(Product x:this.Cart.keySet()) {
			if(x.getpId()==id)
			{
				int value = Cart.get(paob.getAProductbyId(id));
				this.Cart.replace(paob.getAProductbyId(id), value+q);
				return true;
			}
		}
		if(paob.getAProductbyId(id)!=null) {
			this.Cart.put(paob.getAProductbyId(id), q);
			return true;
		}
		return false;
	}
	
	public boolean removeProductCartbyID(int id,int q) {
		for(Product x:this.Cart.keySet()) {
			if(x.getpId()==id)
			{
				int value = this.Cart.get(paob.getAProductbyId(id));
				if(value<q) 
					return false;
				this.Cart.replace(paob.getAProductbyId(id), value-q);
				return true;
			}
		}
		return false;
	}
	
	public int billing(){
		int BillAmount = 0;
		for (Product x:this.Cart.keySet())
		{
			BillAmount += x.getpPrice()*this.Cart.get(x);
		}
		this.Cart = new HashMap<Product, Integer>(); 
		return BillAmount;
	}
	
}
