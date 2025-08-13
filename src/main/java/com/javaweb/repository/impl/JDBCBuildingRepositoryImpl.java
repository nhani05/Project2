package com.javaweb.repository.impl;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.javaweb.builder.BuildingSearch;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.utils.JDBCConnectionUtil;
import com.javaweb.utils.StringUtil;

@Repository
public class JDBCBuildingRepositoryImpl implements BuildingRepository {
	
	private static void joinTable(BuildingSearch buildingSearch, StringBuilder sql) {
		if(StringUtil.checkAttribute(buildingSearch.getStaffId()) == true) {
			sql.append("\nINNER JOIN assignmentbuilding AS a ON a.buildingid = b.id ");
		}
		if(!buildingSearch.getRentType().isEmpty() && buildingSearch.getRentType() != null) {
			sql.append("\nINNER JOIN buildingrenttype AS brt ON brt.buildingid = b.id");
			sql.append("\nINNER JOIN renttype AS rt ON rt.id = brt.renttypeid");
		}
		if(StringUtil.checkAttribute(buildingSearch.getUpperRentalArea()) == true || StringUtil.checkAttribute(buildingSearch.getLowerRentalArea()) == true) {
			sql.append("\nINNER JOIN rentarea AS ra ON ra.buildingid = b.id");
		}
	}
	
	private static void queryNormal(BuildingSearch buildingSearch, StringBuilder condition) {

		try {
			Field[] fields = BuildingSearch.class.getFields();
			for(Field item : fields) {
				item.setAccessible(true);
				String fieldName = item.getName();
				if(!fieldName.equals("staffId") && !fieldName.endsWith("RentalArea") && !fieldName.equals("RentalPrice") 
					&& !fieldName.equals("rentType") ) {
					String valAttribute = item.get(buildingSearch).toString();
					if(StringUtil.checkAttribute(valAttribute) == true) {
						if(StringUtil.isNumber(valAttribute) == true) {
							condition.append(" AND b." + fieldName.toLowerCase() + " = " + valAttribute);
						} else {
							condition.append(" AND b." + fieldName.toLowerCase() + " LIKE '%" + valAttribute + "%'");
						}
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void querySpecial(BuildingSearch buildingSearch, StringBuilder condition) {
		if(StringUtil.checkAttribute(buildingSearch.getStaffId())) {
			condition.append(" AND a.staffid = " + buildingSearch.getStaffId());
		}

		if(StringUtil.checkAttribute(buildingSearch.getLowerRentalArea())) {
			condition.append(" AND ra.value >= " + buildingSearch.getLowerRentalArea());
		}
		if(StringUtil.checkAttribute(buildingSearch.getUpperRentalArea())) {
			condition.append(" AND ra.value <= " + buildingSearch.getUpperRentalArea());
		}

		if(StringUtil.checkAttribute(buildingSearch.getLowerRentalPrice())) {
			condition.append(" AND b.rentprice >= " + buildingSearch.getLowerRentalArea());
		}
		if(StringUtil.checkAttribute(buildingSearch.getUpperRentalPrice())) {
			condition.append(" AND b.rentprice <= " + buildingSearch.getUpperRentalPrice());
		}
		
		condition.append(" AND rt.name IN (" +
			    buildingSearch.getRentType().stream()
			            .map(type -> "'" + type + "'")
			            .collect(Collectors.joining(", ")) +
			")");
	}
	
	private String getBuildingSearchQuery(BuildingSearch buildingSearch) {
		StringBuilder sql = new StringBuilder("SELECT b.id, b.name, b.street, b.ward, b.districtid, b.floorarea, "
				+ "b.servicefee, b.brokeragefee, b.managername, b.managerphonenumber, b.numberofbasement, "
				+ "b.rentprice "
				+ "\nFROM building AS b");
		StringBuilder condition = new StringBuilder("\nWHERE 1 = 1 ");
		joinTable(buildingSearch, sql);
		queryNormal(buildingSearch, condition);
		querySpecial(buildingSearch, condition);
		sql.append(";");
		return sql.toString();
	}
	public List<BuildingEntity> findAllBuildings(BuildingSearch buildingSearch) {
		List<BuildingEntity> result = new ArrayList<BuildingEntity>();
		
		try(Connection con = JDBCConnectionUtil.getConnections()){
			Statement stm = con.createStatement();
			String sql = this.getBuildingSearchQuery(buildingSearch);
			System.out.println(sql);
			ResultSet rs = stm.executeQuery(sql);
	
			while(rs.next()) {
				BuildingEntity buildingTmp = new BuildingEntity();
				buildingTmp.setId(rs.getLong("id"));
				buildingTmp.setBuildingName(rs.getString("name"));
				
				buildingTmp.setStreet(rs.getString("street"));
				buildingTmp.setWard(rs.getString("ward"));
				buildingTmp.setDistrictEntity(null);//.setDistrictId(rs.getLong("districtid"));
				
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
