package com.example.springblog.blogapp.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import com.example.springblog.blogapp.model.User;
import com.example.springblog.blogapp.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user= userRepository.findByUserName(username);
        return user.map(CustomUserDetails::new).orElseThrow(()->new UsernameNotFoundException("User not found"));
    }


    
}
