package model.dao;

import java.util.List;

import model.entities.Departmet;
import model.entities.Seller;

public interface SellerDao {
	void insert(Seller dp );
	void update(Seller dp );
	void deleteById(Integer id);
	Seller findById(Integer id);
	List<Seller> findAll();
static List<Seller> findByDepartmet(Departmet dp) {
		// TODO Auto-generated method stub
		return null;
	}
}
