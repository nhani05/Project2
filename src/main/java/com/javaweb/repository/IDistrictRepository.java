package com.javaweb.repository;

import com.javaweb.repository.entity.DistrictEntity;

public interface IDistrictRepository {
	DistrictEntity  findDistrictNameById(Long id);

}
