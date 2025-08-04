package com.javaweb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.model.BuildingDTO;
import com.javaweb.model.BuildingSearchRequestDTO;
import com.javaweb.service.BuildingService;

@RestController
public class BuildingAPI {
	@Autowired
	private BuildingService buildingService;
	@GetMapping("/api/test/")
	public List<BuildingDTO> getBuilding(@ModelAttribute BuildingSearchRequestDTO requestClient) {
		List<BuildingDTO> result = buildingService.findAllBuildings(requestClient);
		return result;
	}
	
}
