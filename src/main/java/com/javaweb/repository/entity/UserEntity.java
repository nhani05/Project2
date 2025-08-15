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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;// bigint AI PK

	@Column(name = "username", nullable = false, unique = true)
	private String userame;// varchar(255)

	@Column(name = "password", nullable = false)
	private String password;// varchar(255)

	@Column(name = "fullname")
	private String fullname;// varchar(255)

	@Column(name = "phone")
	private String phone;// varchar(255)

	@Column(name = "email")
	private String email;// varchar(255)

	@Column(name = "status")
	private Integer status;// int

	@Column(name = "createddate")
	private Date createdDate;// datetime

	@Column(name = "modifieddate")
	private Date modifiedDate;// datetime

	@Column(name = "createby")
	private Date createdBy;// varchar(255)

	@Column(name = "modifiedby")
	private Date modifiedBy;// varchar(255)

//  Thu cong
//	@OneToMany(mappedBy = "userEntity", fetch = FetchType.LAZY)
//	private List<UserRoleEntity> userRoleEntities = new ArrayList<UserRoleEntity>();

//  Tu dong
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_role", // bảng trung gian
			joinColumns = @JoinColumn(name = "userid", nullable = false), // khóa ngoại đầu tiên tham chiếu tới bảng hiện tại
			inverseJoinColumns = @JoinColumn(name = "roleid", nullable = false)) // khóa ngoại tiệp theo tham chiếu tới bảng role
	private List<RoleEntity> roleEntities = new ArrayList<RoleEntity>();

	public List<RoleEntity> getRoleEntities() {
		return roleEntities;
	}

	public void setRoleEntities(List<RoleEntity> roleEntities) {
		this.roleEntities = roleEntities;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserame() {
		return userame;
	}

	public void setUserame(String userame) {
		this.userame = userame;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public Date getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Date modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

//	public List<UserRoleEntity> getUserRoleEntities() {
//		return userRoleEntities;
//	}
//
//	public void setUserRoleEntities(List<UserRoleEntity> userRoleEntities) {
//		this.userRoleEntities = userRoleEntities;
//	}

}
