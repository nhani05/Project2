package com.javaweb.model;

//java bean
public class BuildingSearchRequestDTO {
	private String buildingName;
	private String ward, street, direction;
	private Integer districtId, floorArea, numberOfBasement, level;
	private Integer lowerRentalArea, upperRentalArea;
	private Integer lowerRentalPrice, upperRentalPrice;
	private String managerName, managerPhoneNumber;
	private Integer staffId;
	private String rentType;
	
	public String getRentType() {
		return rentType;
	}
	public void setRentType(String rentType) {
		this.rentType = rentType;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public Integer getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}
	public Integer getFloorArea() {
		return floorArea;
	}
	public void setFloorArea(Integer floorArea) {
		this.floorArea = floorArea;
	}
	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}
	public void setNumberOfBasement(Integer numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getLowerRentalArea() {
		return lowerRentalArea;
	}
	public void setLowerRentalArea(Integer lowerRentalArea) {
		this.lowerRentalArea = lowerRentalArea;
	}
	public Integer getUpperRentalArea() {
		return upperRentalArea;
	}
	public void setUpperRentalArea(Integer upperRentalArea) {
		this.upperRentalArea = upperRentalArea;
	}
	public Integer getLowerRentalPrice() {
		return lowerRentalPrice;
	}
	public void setLowerRentalPrice(Integer lowerRentalPrice) {
		this.lowerRentalPrice = lowerRentalPrice;
	}
	public Integer getUpperRentalPrice() {
		return upperRentalPrice;
	}
	public void setUpperRentalPrice(Integer upperRentalPrice) {
		this.upperRentalPrice = upperRentalPrice;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerPhoneNumber() {
		return managerPhoneNumber;
	}
	public void setManagerPhoneNumber(String managerPhoneNumber) {
		this.managerPhoneNumber = managerPhoneNumber;
	}
	public Integer getStaffId() {
		return staffId;
	}
	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}
	
	
}

