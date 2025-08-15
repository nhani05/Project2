package com.javaweb.model;

public class BuildingRequestDTO {
	private String name, street, ward;
	private Long districtId;
//	private Integer rentprice;
//	public Integer getRentprice() {
//		return rentprice;
//	}
//	public void setRentprice(Integer rentprice) {
//		this.rentprice = rentprice;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public Long getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}
	
}
