package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.*;
import com.javaweb.repository.entity.BuildingEntity;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {
	private static final String URL = "jdbc:mysql://localhost:3306/estatebasic";
	private static final String USER_NAME = "root";
	private static final String PASS_WORD = "123456";
	
	
	public String getBuildingSearchQuery(String name, Long districtId) {
		StringBuilder sql = new StringBuilder("SELECT * FROM building WHERE 1 = 1");
		
		if(name != null && !name.equals("")) {
			sql.append(" AND name LIKE '%" + name + "%'");
		}
		
		if(districtId != null) {
			sql.append(" AND districtid = " + districtId.toString());
		}
		return sql.toString();
	}
	@Override
	public List<BuildingEntity> findAllBuildings(String name, Long districtId) {
		List<BuildingEntity> result = new ArrayList<BuildingEntity>();
		try{
			Connection con = DriverManager.getConnection(URL, USER_NAME, PASS_WORD);
			
			System.out.println();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(this.getBuildingSearchQuery(name, districtId));
	
			while(rs.next()) {
				BuildingEntity buildingTmp = new BuildingEntity();
				buildingTmp.setName(rs.getString("name"));
				buildingTmp.setNumberOfBasement(rs.getInt("numberofbasement"));
				buildingTmp.setStreet(rs.getString("street"));
				buildingTmp.setWard(rs.getString("ward"));
				result.add(buildingTmp);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("failed");
		}
		return result;
	}
	
}
