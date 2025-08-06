package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.model.BuildingDTO;
import com.javaweb.model.BuildingSearchRequestDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService{
	@Autowired
	private BuildingRepository buildingRepository;
	
	@Override
	public List<BuildingDTO> findAllBuildings(BuildingSearchRequestDTO requestClient) {
		// TODO Auto-generated method stub
		List<BuildingEntity> buildingEntities = buildingRepository.findAllBuildings(requestClient);
		List<BuildingDTO> result = new ArrayList<BuildingDTO>();
		for(BuildingEntity building : buildingEntities) {
			BuildingDTO buildingDTO = new BuildingDTO();
			buildingDTO.setBuildingName(building.getBuildingName());
			
			String address = building.getStreet() + ", " + building.getWard() + ", " + "Quận " 
							+ building.getDistrictId();
			buildingDTO.setAddress(address);
			
			buildingDTO.setNumberOfBasement(building.getNumberOfBasement());
			buildingDTO.setManagerName(building.getManagerName());
			buildingDTO.setManagerPhoneNumber(building.getManagerPhoneNumber());
			
			buildingDTO.setFloorArea(building.getFloorArea());
			buildingDTO.setEmptyArea(null);
			
			buildingDTO.setRentPrice(building.getRentPrice());
			buildingDTO.setServiceFee(building.getServiceFee());
			buildingDTO.setBrokerageFee(building.getBrokerageFee());
			
			result.add(buildingDTO);
		}
		return result;
	}
	
}
