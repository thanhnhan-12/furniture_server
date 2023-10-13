package com.furniro.furniture.repositories;

import com.furniro.furniture.dto.UserDto;
import com.furniro.furniture.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

//    @Query(value = "", nativeQuery = true)
//    List<UserDto> getAllUser();

}
