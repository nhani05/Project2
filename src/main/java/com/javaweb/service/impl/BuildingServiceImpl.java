package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService{
	@Autowired
	private BuildingRepository buildingRepository;
	
	@Override
	public List<BuildingDTO> findAllBuildings(String name, Long districtId) {
		// TODO Auto-generated method stub
		List<BuildingEntity> buildingEntities = buildingRepository.findAllBuildings(name, districtId);
		List<BuildingDTO> result = new ArrayList<BuildingDTO>();
		for(BuildingEntity building : buildingEntities) {
			BuildingDTO buildingDto = new BuildingDTO();
			buildingDto.setName(building.getName());
			buildingDto.setAddress(building.getStreet() + " " + building.getWard());
			buildingDto.setNumberOfBasement(building.getNumberOfBasement());
			result.add(buildingDto);
		}
		return result;
	}
	
}
