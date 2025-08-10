package com.javaweb.builder;

import java.util.List;

public class BuildingSearch {
	private String name;
	private Integer numberOfBasement;
	private String street;
	private String ward;
	private Long districtId;
	private Integer floorArea;
	private String direction;
	private Integer level;
	private Integer lowerRentalArea;
	private Integer upperRentalArea;
	private Integer lowerRentalPrice;
	private Integer upperRentalPrice;
	private String managerName;
	private String managerNumberPhone;
	private Long staffId;
	private List<String> rentType;

	
	private BuildingSearch(BuildingSearchBuilder builder) {
		this.name = builder.name;
		this.numberOfBasement = builder.numberOfBasement;
		this.street = builder.street;
		this.ward = builder.ward;
		this.districtId = builder.districtId;
		this.floorArea = builder.floorArea;
		this.direction = builder.direction;
		this.level = builder.level;
		this.lowerRentalArea = builder.lowerRentalArea;
		this.upperRentalArea = builder.upperRentalArea;
		this.lowerRentalPrice = builder.lowerRentalPrice;
		this.upperRentalPrice = builder.upperRentalPrice;
		this.managerName = builder.managerName;
		this.managerNumberPhone = builder.managerNumberPhone;
		this.staffId = builder.staffId;
		this.rentType = builder.rentType;
	}
	
	public String getName() {
		return name;
	}

	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}

	public String getStreet() {
		return street;
	}

	public String getWard() {
		return ward;
	}

	public Long getDistrictId() {
		return districtId;
	}

	public Integer getFloorArea() {
		return floorArea;
	}

	public String getDirection() {
		return direction;
	}

	public Integer getLevel() {
		return level;
	}

	public Integer getLowerRentalArea() {
		return lowerRentalArea;
	}

	public Integer getUpperRentalArea() {
		return upperRentalArea;
	}

	public Integer getLowerRentalPrice() {
		return lowerRentalPrice;
	}

	public Integer getUpperRentalPrice() {
		return upperRentalPrice;
	}

	public String getManagerName() {
		return managerName;
	}

	public String getManagerNumberPhone() {
		return managerNumberPhone;
	}

	public Long getStaffId() {
		return staffId;
	}

	public List<String> getRentType() {
		return rentType;
	}
	
	

	@Override
	public String toString() {
		return "BuildingSearch [name=" + name + ", numberOfBasement=" + numberOfBasement + ", street=" + street
				+ ", ward=" + ward + ", districtId=" + districtId + ", floorArea=" + floorArea + ", direction="
				+ direction + ", level=" + level + ", lowerRentalArea=" + lowerRentalArea + ", upperRentalArea="
				+ upperRentalArea + ", lowerRentalPrice=" + lowerRentalPrice + ", upperRentalPrice=" + upperRentalPrice
				+ ", managerName=" + managerName + ", managerNumberPhone=" + managerNumberPhone + ", staffId=" + staffId
				+ ", rentType=" + rentType + "]";
	}



	public static class BuildingSearchBuilder {
		private String name;
		private Integer numberOfBasement;
		private String street;
		private String ward;
		private Long districtId;
		private Integer floorArea;
		private String direction;
		private Integer level;
		private Integer lowerRentalArea;
		private Integer upperRentalArea;
		private Integer lowerRentalPrice;
		private Integer upperRentalPrice;
		private String managerName;
		private String managerNumberPhone;
		private Long staffId;
		private List<String> rentType;

		public BuildingSearchBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public BuildingSearchBuilder setNumberOfBasement(Integer numberOfBasement) {
			this.numberOfBasement = numberOfBasement;
			return this;
		}

		public BuildingSearchBuilder setStreet(String street) {
			this.street = street;
			return this;
		}

		public BuildingSearchBuilder setWard(String ward) {
			this.ward = ward;
			return this;
		}

		public BuildingSearchBuilder setDistrictId(Long districtId) {
			this.districtId = districtId;
			return this;
		}

		public BuildingSearchBuilder setFloorArea(Integer floorArea) {
			this.floorArea = floorArea;
			return this;
		}

		public BuildingSearchBuilder setDirection(String direction) {
			this.direction = direction;
			return this;
		}

		public BuildingSearchBuilder setLevel(Integer level) {
			this.level = level;
			return this;
		}

		public BuildingSearchBuilder setLowerRentalArea(Integer lowerRentalArea) {
			this.lowerRentalArea = lowerRentalArea;
			return this;
		}

		public BuildingSearchBuilder setUpperRentalArea(Integer upperRentalArea) {
			this.upperRentalArea = upperRentalArea;
			return this;
		}

		public BuildingSearchBuilder setLowerRentalPrice(Integer lowerRentalPrice) {
			this.lowerRentalPrice = lowerRentalPrice;
			return this;
		}

		public BuildingSearchBuilder setUpperRentalPrice(Integer upperRentalPrice) {
			this.upperRentalPrice = upperRentalPrice;
			return this;
		}

		public BuildingSearchBuilder setManagerName(String managerName) {
			this.managerName = managerName;
			return this;
		}

		public BuildingSearchBuilder setManagerNumberPhone(String managerNumberPhone) {
			this.managerNumberPhone = managerNumberPhone;
			return this;
		}

		public BuildingSearchBuilder setStaffId(Long staffId) {
			this.staffId = staffId;
			return this;
		}

		public BuildingSearchBuilder setRentType(List<String> rentType) {
			this.rentType = rentType;
			return this;
		}
		public BuildingSearch build() {
			BuildingSearch buildingSearch = new BuildingSearch(this);
			return buildingSearch;
		}
	}
	
}
