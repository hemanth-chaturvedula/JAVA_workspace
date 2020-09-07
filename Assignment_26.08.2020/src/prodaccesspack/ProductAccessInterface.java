package prodaccesspack;

import java.util.ArrayList;

import prodpack.Product;
// Client contract
public interface ProductAccessInterface {
	
	 String addProduct(Product prod);
	 ArrayList<Product>  getAllProducts();
	 Product getAProductbyId(int id);
	 Product getAPrdouctbyName();
	 

}
