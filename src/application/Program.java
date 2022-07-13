package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Departmet;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sld = DaoFactory.createSellerDao();
		System.out.println("=== Test 1: seller findById ===");
		Seller sl = sld.findById(3);
		System.out.println("\n=== Test 2: seller findByDepartment ===");
		Departmet dp = new Departmet(2, "hungay");

		List<Seller> list = SellerDao.findByDepartmet(dp);

		for (Seller sl1 : list) {
			System.out.println(sl1);
		}

		System.out.println(sl);
	}

}
