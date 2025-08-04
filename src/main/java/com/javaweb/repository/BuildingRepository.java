package com.javaweb.repository;

import java.util.List;

import com.javaweb.model.BuildingSearchRequestDTO;
import com.javaweb.repository.entity.BuildingEntity;

public interface BuildingRepository {
	List<BuildingEntity> findAllBuildings(BuildingSearchRequestDTO requestClient); // mặc định là public abstract 
}