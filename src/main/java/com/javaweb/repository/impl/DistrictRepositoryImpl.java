package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.DistrictRepository;
import com.javaweb.repository.entity.DistrictEntity;
import com.javaweb.utils.JDBCConnectionUtil;
@Repository
public class DistrictRepositoryImpl implements DistrictRepository{
	private String getDistrictQuery(Long id) {
		StringBuilder sql = new StringBuilder("SELECT d.name FROM district AS d WHERE d.id = " + id + ";");
		return sql.toString();
	}
	@Override
	public DistrictEntity findDistrictNameById(Long id) {
		// TODO Auto-generated method stub
		// co the tao util
		DistrictEntity districtEntity = new DistrictEntity();
		try {
				Connection conn = JDBCConnectionUtil.getConnections();
				Statement sql = conn.createStatement();
				System.out.println(getDistrictQuery(id));
				ResultSet rs = sql.executeQuery(getDistrictQuery(id));
				
				while(rs.next()) {
					districtEntity.setName(rs.getString("name"));
				}
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("failed");
		}
		return districtEntity;
	}
	
}
