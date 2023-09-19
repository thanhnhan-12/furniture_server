package com.furniro.furniture.controllers;

import com.furniro.furniture.dto.WardDto;
import com.furniro.furniture.models.Ward;
import com.furniro.furniture.services.ward.WardService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/api/v1/ward")
@AllArgsConstructor
public class WardController {

    private WardService<Ward> wardService;

    @GetMapping
    public ResponseEntity<List<WardDto>> getWard(@RequestParam int districtID) {
        List<WardDto> wardList = wardService.getWard(districtID);
        if (wardList.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(wardList);
        }
    }

}
