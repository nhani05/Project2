package com.javaweb.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.javaweb.builder.BuildingSearch;
import com.javaweb.repository.IBuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;

@Repository
@Primary
public class BuildingRepositoryImpl implements IBuildingRepository {

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
	
	@Override
	@Transactional
	public void addBuilding(BuildingEntity buildingEntity) {
		entityManager.persist(buildingEntity);
		System.out.println("Them toa nha thanh cong!");
	}

	@Override
	public void deleteBuilding(Long id) {
		// TODO Auto-generated method stub
		BuildingEntity buildingEntity = entityManager.find(BuildingEntity.class, id);
		entityManager.remove(buildingEntity);
		System.out.println("Da xoa toa nha thanh cong!");
	}
	
	

}
