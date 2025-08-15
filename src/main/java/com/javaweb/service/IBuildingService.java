package com.javaweb.service;

import java.util.List;
import java.util.Map;

import com.javaweb.model.BuildingDTO;
import com.javaweb.model.BuildingRequestDTO;

public interface IBuildingService {

	public List<BuildingDTO> findAllBuildings(Map<String, Object> params, List<String> rentType);
	void addBuilding(BuildingRequestDTO buildingRequestDTO);
	void deleteBuilding(Long id);
}
