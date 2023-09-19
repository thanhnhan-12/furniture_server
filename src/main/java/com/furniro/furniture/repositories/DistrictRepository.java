package com.furniro.furniture.repositories;

import com.furniro.furniture.dto.DistrictDto;
import com.furniro.furniture.models.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepository extends JpaRepository<District, Integer> {
    @Query(value = "Select districtid as districtID, district_name as districtName, provinceid as provinceID" +
            " from district", nativeQuery = true)
    List<DistrictDto> getDistrict();
}
