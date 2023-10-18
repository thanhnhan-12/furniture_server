package com.furniro.furniture.repositories;

import com.furniro.furniture.dto.UserAdminDto;
import com.furniro.furniture.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT COUNT(*) as totalUsers\n" +
            "FROM user as Us", nativeQuery = true)
    List<UserAdminDto> userStatistics();

}
