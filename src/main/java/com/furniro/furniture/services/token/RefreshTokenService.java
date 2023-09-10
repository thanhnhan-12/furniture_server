package com.furniro.furniture.services.token;

public interface RefreshTokenService {
    public com.furniro.furniture.models.RefreshToken findByToken(String token);

    com.furniro.furniture.models.RefreshToken createRefreshToken(int userID);

    com.furniro.furniture.models.RefreshToken verifyExpiration(com.furniro.furniture.models.RefreshToken token);

    int deleteByUserId(int userID);

    boolean existsByUserId(int userID);
}
