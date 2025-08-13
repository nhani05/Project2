package com.javaweb.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.javaweb.builder.BuildingSearch;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;

@Repository
@Primary
public class BuildingRepositoryImpl implements BuildingRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<BuildingEntity> findAllBuildings(BuildingSearch buildingSearch) {
		// TODO Auto-generated method stub
		//JQL sẽ làm việc trên Entity
//		String sql = "FROM BuildingEntity";
//		Query query = entityManager.createQuery(sql, BuildingEntity.class); // map đối tượng, không cần set dữ liệu
		String sql = "SELECT * FROM building AS b WHERE b.districtid = 1";
		Query query = entityManager.createNativeQuery(sql, BuildingEntity.class);
		return query.getResultList();
	}

}
