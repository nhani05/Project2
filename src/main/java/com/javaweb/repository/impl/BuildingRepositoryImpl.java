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
	
	
	private void appendLikeCondition(StringBuilder sql, String fieldName, String value) {
		if(value != null && !value.trim().isEmpty() ) {
			sql.append(" AND " + fieldName + " LIKE '%" + value + "%'");
		}
	}
	
	private void appendEqualCondition(StringBuilder sql, String fieldName, Object value) {
	    if (value != null) {
	        sql.append(" AND " + fieldName +" = '" + value.toString() + "'");
	    }
	}
	
	private void appendRangeCondition(StringBuilder sql, String fieldName, Object minValue, Object maxValue) {
	    if (minValue != null) {
	        sql.append(" AND ").append(fieldName).append(" >= ").append(minValue.toString());
	    }
	    if (maxValue != null) {
	        sql.append(" AND ").append(fieldName).append(" <= ").append(maxValue.toString());
	    }
	}
	
	private void appendRentTypeConditions(StringBuilder sql, String rentTypeStr) {
	    if (rentTypeStr != null && !rentTypeStr.trim().isEmpty()) {
	        if (rentTypeStr.contains("Tầng trệt")) {
	            sql.append(" AND rt.name = 'Tầng trệt'");
	        }
	        if (rentTypeStr.contains("Nội thất")) {
	            sql.append(" AND rt.name = 'Nội thất'");
	        }
	        if (rentTypeStr.contains("Nguyên Căn")) {
	            sql.append(" AND rt.name = 'Nguyên căn'");
	        }
	    }
	}
	
	public String getBuildingSearchQuery(BuildingSearchRequestDTO requestClient) {
		StringBuilder sql = new StringBuilder("SELECT b.name, b.street, b.ward, b.districtid, b.floorarea,"
				+ "b.servicefee, b.brokeragefee, b.managername, b.managerphonenumber, b.numberofbasement,"
				+ "b.rentprice"
				+ "\nFROM building AS b");
		
		sql.append("\nINNER JOIN rentarea AS r ON r.buildingid = b.id"
				+ "\nINNER JOIN assignmentbuilding AS a ON a.buildingid = b.id"
				+ "\nINNER JOIN buildingrenttype AS brt ON brt.buildingid = b.id"
				+ "\nINNER JOIN renttype AS rt ON rt.id = brt.renttypeid"
				+ "\nWHERE 1 = 1");
	    appendLikeCondition(sql, "b.name", requestClient.getBuildingName());
	    appendLikeCondition(sql, "b.street", requestClient.getStreet());
	    appendLikeCondition(sql, "b.ward", requestClient.getWard());
	    appendLikeCondition(sql, "b.managername", requestClient.getManagerName());
	    
		appendEqualCondition(sql, "b.managerphonenumber", requestClient.getManagerPhoneNumber());
		appendEqualCondition(sql, "a.staffid", requestClient.getStaffId());
	    appendEqualCondition(sql, "b.numberofbasement", requestClient.getNumberOfBasement());
	    appendEqualCondition(sql, "b.level", requestClient.getLevel());
	    appendEqualCondition(sql, "b.direction", requestClient.getDirection());
	    appendEqualCondition(sql, "b.floorarea", requestClient.getFloorArea());
	    appendEqualCondition(sql, "b.districtid", requestClient.getDistrictId());
		
		appendRangeCondition(sql, "r.value", requestClient.getLowerRentalArea(), requestClient.getUpperRentalArea());
		appendRangeCondition(sql, "b.rentprice", requestClient.getLowerRentalPrice(), requestClient.getUpperRentalPrice());

		appendRentTypeConditions(sql, requestClient.getRentType());
		
		return sql.toString() + ";";
	}
	@Override
	public List<BuildingEntity> findAllBuildings(BuildingSearchRequestDTO requestClient) {
		List<BuildingEntity> result = new ArrayList<BuildingEntity>();
		try{
			Connection con = DriverManager.getConnection(URL, USER_NAME, PASS_WORD);
			
			System.out.println();
			Statement stm = con.createStatement();
			System.out.println(this.getBuildingSearchQuery(requestClient));
			ResultSet rs = stm.executeQuery(this.getBuildingSearchQuery(requestClient));
	
			while(rs.next()) {
				BuildingEntity buildingTmp = new BuildingEntity();
				buildingTmp.setBuildingName(rs.getString("name"));
				
				buildingTmp.setStreet(rs.getString("street"));
				buildingTmp.setWard(rs.getString("ward"));
				buildingTmp.setDistrictId(rs.getInt("districtid"));
				
				buildingTmp.setFloorArea(rs.getInt("floorarea"));
				
				buildingTmp.setServiceFee(rs.getInt("servicefee"));
				buildingTmp.setBrokerageFee(rs.getInt("brokeragefee"));
				
				buildingTmp.setManagerName(rs.getString("managername"));
				buildingTmp.setManagerPhoneNumber(rs.getString("managerphonenumber"));
				
				buildingTmp.setNumberOfBasement(rs.getInt("numberofbasement"));
				buildingTmp.setRentPrice(rs.getInt("rentprice"));
				result.add(buildingTmp);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("failed");
		}
		return result;
	}
	
}
