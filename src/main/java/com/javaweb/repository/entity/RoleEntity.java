package com.javaweb.repository.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class RoleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; //bigint AI PK 
	
	@Column(name="name", nullable = false)
	private String name; // varchar(255) 
	
	@Column(name="code", nullable = false)
	private String code; // varchar(255) 
	
	@Column(name="createdate")
	private Date createdDate; // datetime 
	
	@Column(name="modifieddate")
	private Date modifiedDate;// datetime 
	
	@Column(name="createby")
	private Date createdBy;// varchar(255) 
	
	@Column(name="modifiedby")
	private Date modifiedby;// varchar(255)
	
//	@OneToMany(mappedBy = "roleEntity", fetch = FetchType.LAZY)
//	private List<UserRoleEntity> userRoleEntities = new ArrayList<UserRoleEntity>();
	
	@ManyToMany(mappedBy = "roleEntities", fetch = FetchType.LAZY)
	private List<UserEntity> userEntities = new ArrayList<UserEntity>();
	
	

	public List<UserEntity> getUserEntities() {
		return userEntities;
	}

	public void setUserEntities(List<UserEntity> userEntities) {
		this.userEntities = userEntities;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Date getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Date createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(Date modifiedby) {
		this.modifiedby = modifiedby;
	}

//	public List<UserRoleEntity> getUserRoleEntities() {
//		return userRoleEntities;
//	}
//
//	public void setUserRoleEntities(List<UserRoleEntity> userRoleEntities) {
//		this.userRoleEntities = userRoleEntities;
//	}
//	
	
}
