package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.builder.BuildingSearch;
import com.javaweb.converter.BuildingDTOConverter;
import com.javaweb.converter.BuildingEntityConverter;
import com.javaweb.converter.BuildingSearchBuilderConverter;
import com.javaweb.model.BuildingDTO;
import com.javaweb.model.BuildingRequestDTO;
import com.javaweb.repository.IBuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.service.IBuildingService;

@Service
public class BuildingServiceImpl implements IBuildingService{
	@Autowired
	private IBuildingRepository buildingRepository;
	
	@Autowired
	private BuildingDTOConverter buildingDTOConverter;
	
	@Autowired 
	private BuildingSearchBuilderConverter buildingSearchBuilderConverter;
	
	@Autowired
	private BuildingEntityConverter buildingEntityConverter;
	
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

	@Override
	public void addBuilding(BuildingRequestDTO buildingRequestDTO) {
		// TODO Auto-generated method stub
		BuildingEntity buildingEntity = buildingEntityConverter.convertToBuildingEntity(buildingRequestDTO);
		buildingRepository.addBuilding(buildingEntity);
		
	}

	@Override
	public void deleteBuilding(Long id) {
		// TODO Auto-generated method stub
		buildingRepository.deleteBuilding(id);
		
	}
	
}
