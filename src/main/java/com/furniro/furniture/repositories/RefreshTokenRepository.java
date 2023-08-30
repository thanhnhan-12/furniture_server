package com.furniro.furniture.repositories;

import com.furniro.furniture.models.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Integer> {
    RefreshToken findByToken(String token);

    int deleteByUserUserID(int userID);

    boolean existsByUserUserID(int userID);
}

