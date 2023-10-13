package com.furniro.furniture.services.user;

import com.furniro.furniture.dto.UserDto;
import com.furniro.furniture.models.User;
import com.furniro.furniture.repositories.UserRepository;
import com.furniro.furniture.utils.PageableCommon;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService<User> {

    private UserRepository userRepository;
    private PageableCommon pageableCommon;

//    @Override
//    public List<UserDto> getAllUser() {
//        return null;
//    }

    @Transactional
    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }


    @Override
    public boolean isUsernameTaken(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean isEmailTaken(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserLogin() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        return this.findByEmail(userDetails.getUsername());
    }
}
