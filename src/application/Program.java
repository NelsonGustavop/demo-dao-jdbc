package application;

import java.util.Date;

import model.entities.Departmet;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Departmet dp = new Departmet(1, "books");
		Seller sl = new Seller(21, "bob", "bob@gmail.com", new Date(), 3000.0, dp);
		System.out.print(dp +","+ sl);
	}

}
