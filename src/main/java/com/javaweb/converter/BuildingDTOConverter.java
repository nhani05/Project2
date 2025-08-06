package com.javaweb.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.DistrictRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.DistrictEntity;
import com.javaweb.repository.entity.RentAreaEntity;

@Component
public class BuildingDTOConverter {
	@Autowired
	private DistrictRepository districtRepository;
	@Autowired
	private RentAreaRepository rentAreaRepository;
	
	private String convertToFloorAreaString(BuildingEntity building) {
		List<RentAreaEntity> rentAreas = rentAreaRepository.getRentAreaByBuildingId(building.getBuildingId());
		List<String> rentAreaValue = new ArrayList<String>();
		for(RentAreaEntity rentAreaEntity : rentAreas) {
			rentAreaValue.add(rentAreaEntity.getValue().toString());
		}	
		return String.join(",", rentAreaValue);
	}
	
	private String getBuildingAdress(BuildingEntity building) {
		DistrictEntity districtEntity = districtRepository.findDistrictNameById(building.getDistrictId());
		return building.getStreet() + ", " + building.getWard() + ", " + districtEntity.getName();
	}
	
	public BuildingDTO convertToBuildingDTO(BuildingEntity building) {
		BuildingDTO buildingDTO = new BuildingDTO();
		
		buildingDTO.setBuildingName(building.getBuildingName());
		buildingDTO.setFloorArea(this.convertToFloorAreaString(building));
		buildingDTO.setAddress(this.getBuildingAdress(building));
		
		buildingDTO.setNumberOfBasement(building.getNumberOfBasement());
		buildingDTO.setManagerName(building.getManagerName());
		buildingDTO.setManagerPhoneNumber(building.getManagerPhoneNumber());
		
		buildingDTO.setEmptyArea(null);
		buildingDTO.setRentPrice(building.getRentPrice());
		buildingDTO.setServiceFee(building.getServiceFee());
		buildingDTO.setBrokerageFee(building.getBrokerageFee());
		
		return buildingDTO;
	}
}
