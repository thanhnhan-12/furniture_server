package com.furniro.furniture.services.ward;

import com.furniro.furniture.dto.WardDto;
import com.furniro.furniture.models.Ward;
import com.furniro.furniture.repositories.WardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WardServiceImp implements WardService<Ward> {

    private WardRepository wardRepository;

    @Override
    public List<WardDto> getWard(int districtID) {
        return wardRepository.getWard(districtID);
    }
}
