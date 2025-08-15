package com.javaweb.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaweb.model.BuildingRequestDTO;
import com.javaweb.repository.entity.BuildingEntity;

@Component
public class BuildingEntityConverter {
	@Autowired
	ModelMapper modelMapper;
	
	public BuildingEntity convertToBuildingEntity(BuildingRequestDTO buildingRequestDTO) {
		BuildingEntity buildingEntity = modelMapper.map(buildingRequestDTO, BuildingEntity.class);
		return buildingEntity;
	}
}
