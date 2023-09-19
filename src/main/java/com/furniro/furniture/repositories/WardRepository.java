package com.furniro.furniture.repositories;

import com.furniro.furniture.dto.WardDto;
import com.furniro.furniture.models.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WardRepository extends JpaRepository<Ward, Integer> {
    @Query(value = "Select w.wardid as wardID, w.ward_name as wardName, w.districtid as districtID, w.provinceid as provinceID\n" +
            "from ward as w, district as d, province as p\n" +
            "where w.districtid = d.districtid and d.districtid = :districtID", nativeQuery = true)
    List<WardDto> getWard(@Param("districtID") int districtID );
}
