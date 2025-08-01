package com.javaweb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaweb.customexception.FieldRequiredException;
import com.javaweb.model.BuildingDTO;
import com.javaweb.model.ErrorResponseDTO;

public class Test {
//	//	public static Connection getConnections() throws ClassNotFoundException, SQLException {
//	//	Class.forName("com.mysql.jdbc.Driver");
//	//	return (Connection) DriverManager.getConnection(URL, USER_NAME, PASS_WORD);
//	//}
//	
//	//@RequestParam(value="name") String name
//	//@RequestParam(value="numberOfBasement") String numberOfBasement
//	//-> Map<String, String>
//	
//	@GetMapping("/api/test/done/")
//	public Object test(@RequestParam(value = "name", required = false) String name,
//			@RequestParam(value = "numberOfBasement", required = false) Integer numberOfBasement,
//			@RequestParam(value = "street") String street, @RequestParam(value = "ward") String ward) {
//		List<BuildingDTO> buildingList = new ArrayList<BuildingDTO>();
//		
//		BuildingDTO building = new BuildingDTO();
//		building.setName(name);
//		building.setNumberOfBasement(numberOfBasement);
//		building.setStreet(street);
//		building.setWard(ward);
//		buildingList.add(building);
//		
//		BuildingDTO toa2 = new BuildingDTO();
//		toa2.setName("WestHome");
//		toa2.setNumberOfBasement(3);
//		toa2.setStreet("Pham Hung");
//		toa2.setWard("Nam Tu Liem");
//		buildingList.add(toa2);
//		
//		
//		try {
//			System.out.println(5/0);
//			valiDate(building);
//		} catch(Exception e) {
//			ErrorResponseDTO error = new ErrorResponseDTO();
//			error.setError(e.getMessage());
//			error.setDetail(Arrays.asList("Name Building is null", "Or number of basement is null"));
//			return error;
//		}
//		return building;
//	}
//	
//	public void valiDate(BuildingDTO building) {
//		if(building.getName() == null || building.getName().equals("") || building.getNumberOfBasement() == null) {
//			throw new FieldRequiredException("name or number of basement is null!");
//		}
//	}
//	
//	//@PostMapping("/api/test/")
//	//public void test(@RequestBody Map<String, String> param) {
//	//	Set<Map.Entry<String, String>> entrySet = param.entrySet();
//	//    for(Map.Entry<String, String> en: entrySet)
//	//    	System.out.println(en.getKey() + " " + en.getValue());
//	//}
//	
//	//@DeleteMapping("/api/test/{id}/")
//	//public void deleteBuilding(@PathVariable Integer id, @RequestParam(value="name") String name) {
//	//	System.out.println("Da xoa thanh cong du lieu toa nha co " + id + " va ten toa nha la: " + name);
//	//}
//	
//	//@PostMapping("/api/test")
//	//public void test(@RequestBody BuildingDTO building) {
//	//	System.out.println(building.getName() + " " + building.getNumberOfBasement() + " " + building.getStreet() + " " + building.getWard());
//	//}
//	
//	//@PostMapping("/api/test/")
//	//public Object getBuilding(@RequestBody BuildingDTO building) {
//	//	// xu ly duoi DB
//	//	try {
//	//		System.out.println(5/0);
//	//	} catch (Exception e) {
//	//		// TODO: handle exception
//	//		System.out.println(e.getMessage());
//	//	}
//	//	return building;
//	//}
//	
//	
//	//@GetMapping("/api/test/")
//	//public List<BuildingDTO> getBuilding() {
//	//	return null;
//	//}
	public static void main(String[] args) {
		try {
			System.out.println(5 / 0);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		System.out.println(6 + 5 * 2);
	}
	
}
