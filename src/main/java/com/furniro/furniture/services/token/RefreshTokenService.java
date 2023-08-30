package com.furniro.furniture.services.token;

import com.furniro.furniture.constants.MessageEnum;
import com.furniro.furniture.exception.ResourceNotFoundException;
import com.furniro.furniture.exception.TokenRefreshException;
import com.furniro.furniture.models.RefreshToken;
import com.furniro.furniture.repositories.RefreshTokenRepository;
import com.furniro.furniture.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class RefreshTokenService implements IRefreshToken {

    private Long refreshTokenDurationMs =20000L;

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public RefreshToken findByToken(String token) {
        RefreshToken refreshToken = refreshTokenRepository.findByToken(token);
        if (refreshToken == null) {
            throw new ResourceNotFoundException(
                    MessageEnum.NOT_FOUND.getFormattedMessage("token", token));
        }

        return refreshToken;
    }

    @Override
    public RefreshToken createRefreshToken(int userID) {
        RefreshToken refreshToken = new RefreshToken();

        refreshToken.setUser(userRepository.findById(userID).get());
        refreshToken.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs));
        refreshToken.setToken(UUID.randomUUID().toString());

        refreshToken = refreshTokenRepository.save(refreshToken);
        return refreshToken;
    }

    @Override
    public RefreshToken verifyExpiration(RefreshToken token) {
        if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
            refreshTokenRepository.delete(token);
            throw new TokenRefreshException(token.getToken(),
                    "Refresh token was expired. Please make a new sign in request");
        }
        return token;
    }

    @Transactional
    @Override
    public int deleteByUserId(int userID) {
        return refreshTokenRepository.deleteByUserUserID(userID);
    }

    @Override
    public boolean existsByUserId(int userID) {
        return refreshTokenRepository.existsByUserUserID(userID);
    }
}
