package com.javaweb.repository.custom;

import java.util.List;

import com.javaweb.builder.BuildingSearch;
import com.javaweb.repository.entity.BuildingEntity;

public interface BuildingRepositoryCustom {
	List<BuildingEntity> findAllBuildings(BuildingSearch buildingSearch); // mặc định là public abstract
	void addBuilding(BuildingEntity buildingEntity);
	void deleteBuilding(Long id);
}