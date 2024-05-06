package com.example.auth_service.service;

import com.example.auth_service.UserDto;
import com.example.auth_service.entity.Role;
import com.example.auth_service.entity.RoleName;
import com.example.auth_service.entity.User;
import com.example.auth_service.repository.RoleRepository;
import com.example.auth_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found" + username);
//        }
//        return (UserDetails) user;
//    }

    public User saveUser(UserDto userDto) {
        Optional<Role> role = roleRepository.findByRole(RoleName.USER);
        if(role.isEmpty()){
            return null;
        }
        User user = new User();
        user.setUsername(userDto.getUsername());
//        user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        user.setPassword(userDto.getPassword());
        user.setRole(role.get());
        userRepository.save(user);
        return user;
    }
}
