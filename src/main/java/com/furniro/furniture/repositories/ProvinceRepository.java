package com.furniro.furniture.repositories;

import com.furniro.furniture.dto.ProvinceDto;
import com.furniro.furniture.models.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Integer> {
    @Query(value = "Select provinceid as provinceID, province_name as provinceName" +
            " from province", nativeQuery = true)
    List<ProvinceDto> getProvince();

}
