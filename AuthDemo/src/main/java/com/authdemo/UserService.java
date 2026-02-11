package com.authdemo;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class UserService {
    private UserRepo repo;
    private JwtUtil jwt;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;

    public String register(UserDto user) {
        MyUser myUser=new MyUser();
        myUser.setPname(user.getPname());
        myUser.setRole("USER");
        myUser.setPassword(this.passwordEncoder.encode(user.getPassword()));

        this.repo.save(myUser);
        return jwt.generateToken(myUser);
    }

    public String login(UserDto myuser) {
        MyUser user=this.repo.findByPname(myuser.getPname()).orElseThrow();
        this. authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(myuser.getPname(),myuser.getPassword()));
        return this.jwt.generateToken((user));

    }
}
