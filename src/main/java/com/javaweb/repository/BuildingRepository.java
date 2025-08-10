package com.javaweb.repository;

import java.util.List;

import com.javaweb.builder.BuildingSearch;
import com.javaweb.repository.entity.BuildingEntity;

public interface BuildingRepository {
	List<BuildingEntity> findAllBuildings(BuildingSearch buildingSearch); // mặc định là public abstract
}