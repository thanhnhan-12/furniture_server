package com.furniro.furniture.services.province;

import com.furniro.furniture.dto.ProvinceDto;
import com.furniro.furniture.models.Province;
import com.furniro.furniture.repositories.ProvinceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProvinceServiceImp implements ProvinceService<Province> {

    private ProvinceRepository provinceRepository;

    @Override
    public List<ProvinceDto> getProvince() {
        return provinceRepository.getProvince();
    }
}
