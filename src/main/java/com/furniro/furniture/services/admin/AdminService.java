package com.furniro.furniture.services.admin;

import com.furniro.furniture.dto.UserAdminDto;

import java.util.List;

public interface AdminService {
    List<UserAdminDto> userStatistics();
}
