package com.furniro.furniture.services.token;

import com.furniro.furniture.models.RefreshToken;

public interface IRefreshToken {
    public RefreshToken findByToken(String token);

    RefreshToken createRefreshToken(int userID);

    RefreshToken verifyExpiration(RefreshToken token);

    int deleteByUserId(int userID);

    boolean existsByUserId(int userID);
}
