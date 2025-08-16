package com.javaweb.repository.custom.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.javaweb.repository.custom.RentAreaRepositoryCustom;
import com.javaweb.repository.entity.RentAreaEntity;
import com.javaweb.utils.JDBCConnectionUtil;


public class RentAreaRepositoryImpl implements RentAreaRepositoryCustom{
	@Override
	public List<RentAreaEntity> getRentAreaByBuildingId(Long buildingId) {
		List<RentAreaEntity> rentAreas = new ArrayList<RentAreaEntity>();
		StringBuilder sql = new StringBuilder("SELECT rt.id, rt.value FROM rentarea AS rt WHERE rt.buildingid = " + buildingId + ";");
		try {
			Connection conn = JDBCConnectionUtil.getConnections();
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql.toString());
			while(rs.next()) {
				RentAreaEntity rentAreaEntity = new RentAreaEntity();
				rentAreaEntity.setValue(rs.getLong("value"));
				rentAreas.add(rentAreaEntity);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return rentAreas;
	}

}
