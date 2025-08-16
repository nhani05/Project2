package com.javaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaweb.repository.custom.BuildingRepositoryCustom;
import com.javaweb.repository.entity.BuildingEntity;


public interface BuildingRepository extends JpaRepository<BuildingEntity, Long>, BuildingRepositoryCustom {
	void deleteByIdIn(List<Long> id);
}

//Derived Query Methods in Spring Data JPA Repositories
// sinh truy vấn tự dộng từ tên method
//
//2. Các từ khóa Spring Data JPA hiểu
//
//Hành động: findBy, readBy, getBy, countBy, existsBy, deleteBy
//
//Toán tử so sánh: Equals, LessThan, GreaterThan, Like, Between, In, NotIn, IsNull, IsNotNull
//
//Kết hợp điều kiện: And, Or