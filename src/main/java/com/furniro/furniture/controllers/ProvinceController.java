package com.furniro.furniture.controllers;

import com.furniro.furniture.dto.ProvinceDto;
import com.furniro.furniture.models.Province;
import com.furniro.furniture.services.province.ProvinceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/api/v1/province")
@AllArgsConstructor
public class ProvinceController {

    private ProvinceService<Province> provinceService;

    @GetMapping
    public ResponseEntity<List<ProvinceDto>> getProvince() {
        List<ProvinceDto> provinceList = provinceService.getProvince();
        if (provinceList.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(provinceList);
        }
    }

}
