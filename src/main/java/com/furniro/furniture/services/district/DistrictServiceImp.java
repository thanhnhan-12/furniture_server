package com.furniro.furniture.services.district;

import com.furniro.furniture.dto.DistrictDto;
import com.furniro.furniture.models.District;
import com.furniro.furniture.repositories.DistrictRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DistrictServiceImp implements DistrictService<District> {

    private DistrictRepository districtRepository;

    @Override
    public List<DistrictDto> getDistrict() {
        return districtRepository.getDistrict();
    }
}
