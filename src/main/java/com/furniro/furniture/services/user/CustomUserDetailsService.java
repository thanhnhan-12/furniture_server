package com.furniro.furniture.services.user;

import com.furniro.furniture.models.Role;
import com.furniro.furniture.models.User;
import com.furniro.furniture.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElse(null);

        System.out.println("Vao loadUser " );

        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean isAccountNonLocked = !user.isLocked();

//        Collection<String> list = Arrays.asList(user.getRoles().getName());

//        Set<GrantedAuthority> authorities = list
//                .stream()
//                .map(SimpleGrantedAuthority::new).collect(Collectors.toSet());

        Set<GrantedAuthority> authorities = user
                .getRoles()
                .stream()
                .map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                enabled,
                accountNonExpired,
                credentialsNonExpired,
                isAccountNonLocked,
                (Collection<? extends GrantedAuthority>) authorities);
    }
}
