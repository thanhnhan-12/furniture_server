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

    @Query(value = "Select Us.userid as userID, Us.first_name as firstName, Us.last_name as lastName, Us.email as email, Us.phone_number as phoneNumber," +
            " Ro.roleid as roleID, Ro.name as name\n" +
            "from user as Us, roles as Ro, user_roles as Ur\n" +
            "where Us.userid = Ur.user_id and Ur.role_id = Ro.roleid", nativeQuery = true)
    List<UserDto> getAllUser();

}
