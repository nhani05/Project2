package com.javaweb.converter;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaweb.model.BuildingDTO;
//import com.javaweb.repository.DistrictRepository;
//import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.DistrictEntity;
import com.javaweb.repository.entity.RentAreaEntity;

@Component
public class BuildingDTOConverter {
//	@Autowired
//	private DistrictRepository districtRepository;
//	@Autowired
//	private RentAreaRepository rentAreaRepository;
	@Autowired
	private ModelMapper modelMapper;
	
	private String convertToFloorAreaString(BuildingEntity building) {
		List<RentAreaEntity> rentAreas = building.getAreaEntities();
		List<String> rentAreaValue = new ArrayList<String>();
		for(RentAreaEntity rentAreaEntity : rentAreas) {
			rentAreaValue.add(rentAreaEntity.getValue().toString());
		}	
		return String.join(",", rentAreaValue);
	}
	
	private String getBuildingAdress(BuildingEntity building) {
		DistrictEntity districtEntity = building.getDistrictEntity();
		return building.getStreet() + ", " + building.getWard() + ", " + districtEntity.getName();
	}
	
	public BuildingDTO convertToBuildingDTO(BuildingEntity building) {
		BuildingDTO buildingDTO = modelMapper.map(building, BuildingDTO.class);		
		buildingDTO.setFloorArea(this.convertToFloorAreaString(building));
		buildingDTO.setAddress(this.getBuildingAdress(building));	
		return buildingDTO;
	}
}
/*////////////////////////////////////////////////
 * nếu không sử dụng model mapper thì sẽ phải set từng thuộc tính
 do đó sử dụng model mapper để ánh xạ thuộc tính từ entity vào trong dto nếu cùng tên thuộc tính
 
 *//////////////////////////////////////////////////
//		BuildingDTO buildingDTO = new BuildingDTO();
//		buildingDTO = modelMapper.map(buildingDTO, buildingDTO.getClass());
//		buildingDTO.setBuildingName(building.getBuildingName());
//		buildingDTO.setNumberOfBasement(building.getNumberOfBasement());
//		buildingDTO.setManagerName(building.getManagerName());
//		buildingDTO.setManagerPhoneNumber(building.getManagerPhoneNumber());
//		buildingDTO.setEmptyArea(building.getEmptyArea());
//		buildingDTO.setRentPrice(building.getRentPrice());
//		buildingDTO.setServiceFee(building.getServiceFee());
//		buildingDTO.setBrokerageFee(building.getBrokerageFee());
////////////////////////////////////////////////////////////////