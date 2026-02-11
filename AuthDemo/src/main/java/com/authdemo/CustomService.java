package com.authdemo;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomService implements UserDetailsService {
    private UserRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      MyUser user = this.repo.findByPname(username).orElseThrow();
      return User.builder()
              .username(user.getPname())
              .password(user.getPassword())
              .roles(user.getRole())
              .build();

    }
}
