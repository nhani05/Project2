package com.javaweb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.model.BuildingDTO;
import com.javaweb.service.BuildingService;

@RestController
public class BuildingAPI {
	@Autowired
	private BuildingService buildingService;
	@GetMapping("/api/test/")
	public List<BuildingDTO> getBuilding(@RequestParam(value="name", required= false) String name,
										@RequestParam(value="districtId", required= false) Long districtId,
										@RequestParam(value ="typeCode", required = false) List<String> typeCode) {
		List<BuildingDTO> result = buildingService.findAllBuildings(name, districtId);
		return result;
	}
	
}
