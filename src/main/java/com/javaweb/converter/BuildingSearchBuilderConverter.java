package com.javaweb.converter;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.javaweb.builder.BuildingSearch;
import com.javaweb.utils.MapUtil;

@Component
public class BuildingSearchBuilderConverter {
	public BuildingSearch convertToBuildingSearch(Map<String, Object> params, List<String> rentType) {
		BuildingSearch buildingSearch = new BuildingSearch.BuildingSearchBuilder()
				.setName(MapUtil.getObject(params, "name", String.class))
				.setNumberOfBasement(MapUtil.getObject(params, "numberOfBasement", Integer.class))
				.setStreet(MapUtil.getObject(params, "street", String.class))
				.setWard(MapUtil.getObject(params, "ward", String.class))
				.setDistrictId(MapUtil.getObject(params, "districtId", Long.class))
				.setFloorArea(MapUtil.getObject(params, "floorArea", Integer.class))
				.setDirection(MapUtil.getObject(params, "direction", String.class))
				.setLevel(MapUtil.getObject(params, "level", Integer.class))
				.setLowerRentalArea(MapUtil.getObject(params, "lowerRentalArea", Integer.class))
				.setUpperRentalArea(MapUtil.getObject(params, "upperRentalArea", Integer.class))
				.setLowerRentalPrice(MapUtil.getObject(params, "lowerRentalPrice", Integer.class))
				.setUpperRentalPrice(MapUtil.getObject(params, "upperRentalPrice", Integer.class))
				.setManagerName(MapUtil.getObject(params, "managerName", String.class))
				.setManagerNumberPhone(MapUtil.getObject(params, "managerNumberPhone", String.class))
				.setStaffId(MapUtil.getObject(params, "staffId", Long.class))
				.setRentType(rentType)
				.build();
		return buildingSearch;
	}
}
