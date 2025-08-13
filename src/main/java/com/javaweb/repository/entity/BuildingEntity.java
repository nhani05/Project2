package com.javaweb.repository.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="building")
public class BuildingEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
	private String buildingName;
	
	@Column(name="street")
	private String street;
	
	@Column(name="ward")
	private String ward; // tên tòa nhà, phố, đường
	
	@Column(name="floorarea")
	private Integer floorArea;
	
	@Column(name="numberofbasement")
	private Integer numberOfBasement;
	
	@Column(name="rentprice")
	private Integer rentPrice;
	
//	@Column(name="emptyarea")
//	private Integer emptyArea;
	
	@Column(name="servicefee")
    private Integer serviceFee;
	
	@Column(name="brokeragefee")
    private Integer brokerageFee;

//	@Column(name="districtid")
//	private Long districtId;
	
	@Column(name="managername")
	private String managerName;
	
	@Column(name="managerphonenumber")
	private String managerPhoneNumber; // tên quản lý, số điện thoại
	
	@ManyToOne
	@JoinColumn(name="districtid") // fix lỗi này khi chạy sẽ tạo ra schema mới
	private DistrictEntity districtEntity;
	
	@OneToMany(mappedBy = "buildingEntity", fetch = FetchType.LAZY)
	private List<RentAreaEntity> areaEntities = new ArrayList<RentAreaEntity>();
	
	
	public DistrictEntity getDistrictEntity() {
		return districtEntity;
	}
	public void setDistrictEntity(DistrictEntity districtEntity) {
		this.districtEntity = districtEntity;
	}
//	public Integer getEmptyArea() {
//		return emptyArea;
//	}
//	public void setEmptyArea(Integer emptyArea) {
//		this.emptyArea = emptyArea;
//	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
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
	public Integer getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(Integer rentPrice) {
		this.rentPrice = rentPrice;
	}
//	public Long getDistrictId() {
//		return districtId;
//	}
//	public void setDistrictId(Long districtId) {
//		this.districtId = districtId;
//	}
	public Integer getServiceFee() {
		return serviceFee;
	}
	public void setServiceFee(Integer serviceFee) {
		this.serviceFee = serviceFee;
	}
	public Integer getBrokerageFee() {
		return brokerageFee;
	}
	public void setBrokerageFee(Integer brokerageFee) {
		this.brokerageFee = brokerageFee;
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
	public List<RentAreaEntity> getAreaEntities() {
		return areaEntities;
	}
	public void setAreaEntities(List<RentAreaEntity> areaEntities) {
		this.areaEntities = areaEntities;
	}

	
}
