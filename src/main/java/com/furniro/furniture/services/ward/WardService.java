package com.furniro.furniture.services.ward;

import com.furniro.furniture.dto.WardDto;

import java.util.List;

public interface WardService<W> {
    List<WardDto> getWard(int districtID);

}
