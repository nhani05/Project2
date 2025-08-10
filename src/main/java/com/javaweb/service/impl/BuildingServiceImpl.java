package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.builder.BuildingSearch;
import com.javaweb.converter.BuildingDTOConverter;
import com.javaweb.converter.BuildingSearchBuilderConverter;
import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService{
	@Autowired
	private BuildingRepository buildingRepository;
	@Autowired
	private BuildingDTOConverter buildingDTOConverter;
	@Autowired BuildingSearchBuilderConverter buildingSearchBuilderConverter;
	
	@Override
	public List<BuildingDTO> findAllBuildings(Map<String, Object> params, List<String> rentType) {
		// TODO Auto-generated method stub
		BuildingSearch buildingSearch = buildingSearchBuilderConverter.convertToBuildingSearch(params, rentType);
		List<BuildingEntity> buildingEntities = buildingRepository.findAllBuildings(buildingSearch);
		List<BuildingDTO> result = new ArrayList<BuildingDTO>();
		for(BuildingEntity building : buildingEntities) {
			result.add(buildingDTOConverter.convertToBuildingDTO(building));
		}
		return result;
	}
	
}
