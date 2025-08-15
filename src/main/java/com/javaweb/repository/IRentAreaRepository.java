package com.javaweb.repository;


import java.util.List;

import com.javaweb.repository.entity.RentAreaEntity;

public interface IRentAreaRepository {
	List<RentAreaEntity> getRentAreaByBuildingId(Long buildingId);
}
