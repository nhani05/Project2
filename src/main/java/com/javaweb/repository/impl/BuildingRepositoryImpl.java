package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.utils.JDBCConnectionUtil;
import com.javaweb.utils.StringUtil;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {
	
	private static void joinTable(Map<String, Object> params, List<String> rentType, StringBuilder sql) {
		String staffId = params.get("staffId").toString(); // String staffId = (String) params.get...... vì coi như là String
		if(StringUtil.checkAttribute(staffId) == true) {
			sql.append("\nINNER JOIN assignmentbuilding AS a ON a.buildingid = b.id ");
		}
		if(!rentType.isEmpty() && rentType != null) {
			sql.append("\nINNER JOIN buildingrenttype AS brt ON brt.buildingid = b.id");
			sql.append("\nINNER JOIN renttype AS rt ON rt.id = brt.renttypeid");
		}
		String lowerRentalArea = params.get("lowerRentalArea").toString();
		String upperRentalArea = params.get("upperRentalArea").toString();
		if(StringUtil.checkAttribute(upperRentalArea) == true || StringUtil.checkAttribute(lowerRentalArea) == true) {
			sql.append("\nINNER JOIN rentarea AS ra ON ra.buildingid = b.id");
		}
	}
	
	private static void queryNormal(Map<String, Object> params, StringBuilder condition) {
		for(Map.Entry<String, Object> item : params.entrySet()) {
			// nếu là null thì không cần điều kiện
			String attribute = item.getKey().toString();
			if(!attribute.equals("staffId") && !attribute.endsWith("RentalArea") && !attribute.equals("RentalPrice") 
				&& !attribute.equals("rentType") ) {
				String valAttribute = item.getValue().toString();
				if(StringUtil.checkAttribute(valAttribute) == true) {
					if(StringUtil.isNumber(valAttribute) == true) {
						condition.append(" AND b." + attribute.toLowerCase() + " = " + valAttribute);
					} else {
						condition.append(" AND b." + attribute.toLowerCase() + " LIKE '%" + valAttribute + "%'");
					}
				}
			}
		}
	}
	
	private static void querySpecial(Map<String, Object> params, List<String> rentType, StringBuilder condition) {
		String staffId = params.get("staffId").toString();
		if(StringUtil.checkAttribute(staffId)) {
			condition.append(" AND a.staffid = " + staffId);
		}
		String lowerRentalArea = params.get("lowerRentalArea").toString();
		String upperRentalArea = params.get("upperRentalArea").toString();
		if(StringUtil.checkAttribute(lowerRentalArea)) {
			condition.append(" AND ra.value >= " + lowerRentalArea);
		}
		if(StringUtil.checkAttribute(upperRentalArea)) {
			condition.append(" AND ra.value <= " + upperRentalArea);
		}
		
		String lowerRentalPrice = params.get("lowerRentalPrice").toString();
		String upperRentalPrice = params.get("upperRentalPrice").toString();
		if(StringUtil.checkAttribute(lowerRentalPrice)) {
			condition.append(" AND b.rentprice >= " + lowerRentalPrice);
		}
		if(StringUtil.checkAttribute(upperRentalPrice)) {
			condition.append(" AND b.rentprice <= " + upperRentalPrice);
		}
		
		condition.append(" AND rt.name IN (" +
			    rentType.stream()
			            .map(type -> "'" + type + "'")
			            .collect(Collectors.joining(", ")) +
			")");
	}
	
	private String getBuildingSearchQuery(Map<String, Object> params, List<String> rentType) {
		StringBuilder sql = new StringBuilder("SELECT b.id, b.name, b.street, b.ward, b.districtid, b.floorarea, "
				+ "b.servicefee, b.brokeragefee, b.managername, b.managerphonenumber, b.numberofbasement, "
				+ "b.rentprice "
				+ "\nFROM building AS b");
		StringBuilder condition = new StringBuilder("\nWHERE 1 = 1 ");
		joinTable(params, rentType, sql);
		queryNormal(params, condition);
		querySpecial(params, rentType, condition);
		sql.append(condition + ";");
		return sql.toString();
	}
	@Override
	public List<BuildingEntity> findAllBuildings(Map<String, Object> params, List<String> rentType) {
		List<BuildingEntity> result = new ArrayList<BuildingEntity>();
		
		try(Connection con = JDBCConnectionUtil.getConnections()){
			Statement stm = con.createStatement();
			String sql = this.getBuildingSearchQuery(params, rentType);
			System.out.println(sql);
			ResultSet rs = stm.executeQuery(sql);
	
			while(rs.next()) {
				BuildingEntity buildingTmp = new BuildingEntity();
				buildingTmp.setBuildingId(rs.getLong("id"));
				buildingTmp.setBuildingName(rs.getString("name"));
				
				buildingTmp.setStreet(rs.getString("street"));
				buildingTmp.setWard(rs.getString("ward"));
				buildingTmp.setDistrictId(rs.getLong("districtid"));
				
				buildingTmp.setFloorArea(rs.getInt("floorarea"));
				buildingTmp.setEmptyArea(null);
				
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
