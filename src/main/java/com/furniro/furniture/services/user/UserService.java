package com.furniro.furniture.services.user;

import com.furniro.furniture.models.User;
import com.furniro.furniture.repositories.UserRepository;
import com.furniro.furniture.utils.PageableCommon;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class UserService implements UserServiceImp<User> {

    private UserRepository userRepository;
    private PageableCommon pageableCommon;

    @Transactional
    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    @Override
    public boolean isUsernameTaken(String userName) {
        return userRepository.existsByUsername(userName);
    }

    @Override
    public boolean isEmailTaken(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
