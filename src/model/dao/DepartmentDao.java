package model.dao;

import java.util.List;

import model.entities.Departmet;

public interface DepartmentDao {
	void insert(Departmet dp );
	void update(Departmet dp );
	void deleteById(Integer id);
	Departmet findById(Integer id);
	List<Departmet> findAll();
	
}
