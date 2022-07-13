package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Departmet;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {

	private Connection conn;

	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller dp) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Seller dp) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
		st = conn.prepareStatement("SELECT seller.*,department.Name as DepName "
				+"FROM seller INNER JOIN department "
				+"ON seller.DepartmentId = department.Id "
				+"WHERE seller.Id = ? ");
		st.setInt(1, id);
		rs = st.executeQuery();
		if(rs.next()) {
			Departmet dep = instatiateDepartment(rs);
			Seller obj = instantiateSeller(rs,dep);
			return obj;
			}
		return null;
	}
		catch(SQLException e ) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
			
		}
	}	

	private Seller instantiateSeller(ResultSet rs, Departmet dep) throws SQLException {
		Seller obj = new Seller();	
		obj.setId(rs.getInt("Id"));
		obj.setName(rs.getString("Name"));
		obj.setEmail(rs.getString("Email"));
		obj.setBaseSalary(rs.getDouble("BaseSalary"));
		obj.setBirthDate(rs.getDate("BirthDate"));
		obj.setDepartment(dep);
		return obj;
	}

	private Departmet instatiateDepartment(ResultSet rs) throws SQLException {
		Departmet dep = new Departmet();
		
		dep.setId(rs.getInt("DepartmentId"));
		dep.setName(rs.getString("DepName"));
		return dep;
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seller> findByDepartmet(Departmet dp) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
		st = conn.prepareStatement(
				"SELECT seller.*,department.Name as DepName "
				+"FROM seller INNER JOIN department "
				+"ON seller.DepartmentId = department.Id "
				+"WHERE DepartmentId = ? "
				+ "ORDER BY Name");
		st.setInt(1, dp.getId());
		rs = st.executeQuery();
		List<Seller>list = new ArrayList<>();
		Map<Integer,Departmet> map = new HashMap<>();
		 while(rs.next()){
			 
			 Departmet dep = map.get(rs.getInt("DepartmentId"));
			 if(dep == null) {
				 dep = instantiateDepartmet(rs);
				 map.put(rs.getInt("DepartmentId"), dep);
			 }
			
			Seller obj = instantiateSeller(rs,dep);
			list.add(obj);
			}
		return list;
	}
		catch(SQLException e ) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	private Departmet instantiateDepartmet(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}

}
