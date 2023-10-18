package com.furniro.furniture.services.admin;

import com.furniro.furniture.dto.UserAdminDto;
import com.furniro.furniture.repositories.AdminRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdminServiceImp implements AdminService {

    AdminRepository adminRepository;

    @Override
    public List<UserAdminDto> userStatistics() {
        return adminRepository.userStatistics();
    }
}
