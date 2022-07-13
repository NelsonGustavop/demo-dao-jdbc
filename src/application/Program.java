package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sld = DaoFactory.createSellerDao();
		System.out.println("=== Test 1: seller findById ===");
		Seller sl = sld.findById(3);
		System.out.println(sl);
	}

}
