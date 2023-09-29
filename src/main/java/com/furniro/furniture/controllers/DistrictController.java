package com.furniro.furniture.controllers;

import com.furniro.furniture.dto.DistrictDto;
import com.furniro.furniture.models.District;
import com.furniro.furniture.services.district.DistrictService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/api/v1/district")
@AllArgsConstructor
public class DistrictController {

    private DistrictService<District> districtService;

    @GetMapping
    public ResponseEntity<List<DistrictDto>> getDistrict() {
        List<DistrictDto> districtList = districtService.getDistrict();
        if (districtList.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(districtList);
        }
    }

}
