package com.furniro.furniture.repositories;

import com.furniro.furniture.dto.DistrictDto;
import com.furniro.furniture.models.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepository extends JpaRepository<District, Integer> {
    @Query(value = "Select districtid as districtID, district_name as districtName, provinceid as provinceID" +
            " from district", nativeQuery = true)
    List<DistrictDto> getDistrict();

//    @Query(value = "Select d.districtid as districtID, d.district_name as districtName, d.provinceid as provinceID\n" +
//            "from district as d, province as p\n" +
//            "where p.provinceid = d.provinceid and d.provinceid = :provinceID", nativeQuery = true)
//    List<DistrictDto> getDistrict(@Param("provinceID") int provinceID);

}
