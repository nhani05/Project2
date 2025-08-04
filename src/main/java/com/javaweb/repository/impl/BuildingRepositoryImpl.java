package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.model.BuildingSearchRequestDTO;
import com.javaweb.repository.*;
import com.javaweb.repository.entity.BuildingEntity;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {
	private static final String URL = "jdbc:mysql://localhost:3306/estatebasic";
	private static final String USER_NAME = "root";
	private static final String PASS_WORD = "123456";
	
	
	public String getBuildingSearchQuery(BuildingSearchRequestDTO requestClient) {
		StringBuilder sql = new StringBuilder("SELECT * FROM building AS b WHERE 1 = 1");
		
		sql.append("\nINNER JOIN rentarea AS r ON rentarea.buildingid = builiding.id"
				+ "\nINNER JOIN assignmentbuilding AS a ON assignmentbuilding.buildingid = building.id");
		if(requestClient.getBuildingName() != null && !requestClient.getBuildingName().equals("")) {
			sql.append(" AND b.name LIKE '%" + requestClient.getBuildingName() + "%'");
		}
		
		if(requestClient.getFloorArea() != null)
			sql.append(" AND b.floorarea = " + requestClient.getFloorArea().toString());
		
		if(requestClient.getDistrictId() != null) {
			sql.append(" AND b.districtid = " + requestClient.getDistrictId().toString());
		}
		if(requestClient.getWard() != null && ! requestClient.getWard().equals(""))
			sql.append(" AND b.street LIKE '%" + requestClient.getWard() + "%'");
//		if(requestClient.getBuildingName() != null && !requestClient.getBuildingName().equals("")) {
//			sql.append(" AND name LIKE '%" + requestClient.getBuildingName() + "%'");
//		}
		
		if(requestClient.getNumberOfBasement() != null) {
			sql.append(" AND b.numberofbasement = " + requestClient.getNumberOfBasement().toString());
		}
		if(requestClient.getDirection() != null) {
			sql.append(" AND b.direction = " + requestClient.getDirection());
		}
		if(requestClient.getLevel() != null) {
			sql.append(" AND b.level = " + requestClient.getLevel().toString());
		}
		if(requestClient.getLowerRentalArea() != null) {
			sql.append(" AND r.value >= " + requestClient.getLowerRentalArea().toString());
		}
		if(requestClient.getUpperRentalArea() != null) {
			sql.append(" AND r.value <= " + requestClient.getUpperRentalArea().toString());
		}
		
		if(requestClient.getLowerRentalPrice() != null) {
			sql.append(" AND b.rentprice >= " + requestClient.getLowerRentalPrice().toString());
		}
		if(requestClient.getUpperRentalPrice() != null) {
			sql.append(" AND b.rentprice <= " + requestClient.getUpperRentalPrice());
		}
		if(requestClient.getManagerName() != null && !requestClient.getManagerName().equals("")) {
			sql.append(" AND b.managername LIKE '%" + requestClient.getManagerName() + "%'");
		}
		if(requestClient.getManagerPhoneNumber() != null && !requestClient.getManagerPhoneNumber().equals("")) {
			sql.append(" AND b.managerphonenumber = " + requestClient.getManagerPhoneNumber());
		}
		if(requestClient.getStaffId() != null) {
			sql.append(" AND a.staffid = " + requestClient.getStaffId().toString());
		}
		return sql.toString();
	}
	@Override
	public List<BuildingEntity> findAllBuildings(BuildingSearchRequestDTO requestClient) {
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
