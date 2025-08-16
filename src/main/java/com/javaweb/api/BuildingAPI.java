package com.javaweb.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.model.BuildingDTO;
import com.javaweb.model.BuildingRequestDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.service.BuildingService;

@RestController
@PropertySource("classpath:application.properties")
public class BuildingAPI {
	@Autowired
	private BuildingService buildingService;
	
	@Autowired
	private BuildingRepository buildingRepository;
	
	@GetMapping("/api/test/")
	public List<BuildingDTO> getBuilding(@RequestParam Map<String, Object> params,
										@RequestParam(value="rentType", required = false) List<String> rentType) {
		List<BuildingDTO> result = buildingService.findAllBuildings(params, rentType);
		return result;
	}
	
	@PostMapping("/api/test/")
	public void addBuilding(@RequestBody BuildingRequestDTO buildingRequestDTO) {
		buildingService.addBuilding(buildingRequestDTO);
	}
	
	@DeleteMapping("/api/test/{id}")
	public void deleteBuilding(@PathVariable Long id) {
		buildingService.deleteBuilding(id);
	}
	
	@GetMapping("/api/test/{id}")
	public BuildingEntity getBuildingById(@PathVariable Long id) {
		BuildingEntity buildingEntity= buildingRepository.findById(id).get();
		return buildingEntity;
	}
	
	@DeleteMapping("/api/test/{ids}")
	public void deleteBuildings(@PathVariable List<Long> ids) {
		buildingRepository.deleteByIdIn(ids);
	}
	
	@PutMapping("/api/test/")
	void updateBuilding(@RequestBody BuildingRequestDTO buildingRequestDTO) {
		buildingService.updateBuilding(buildingRequestDTO);
	}
}
