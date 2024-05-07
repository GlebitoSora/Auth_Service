//package com.example.auth_service;
//
//
//import com.example.auth_service.entity.Role;
//import com.example.auth_service.entity.RoleName;
//import com.example.auth_service.entity.User;
//import com.example.auth_service.repository.RoleRepository;
//import com.example.auth_service.service.UserService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.when;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
//public class ControllerTest {
//    @Autowired
//    private UserService userService;
//    @MockBean
//    private RoleRepository roleRepository;
//    @Test
//    public void saveUserTest() {
//        User user = new User(7, "Gleb", "12345", new Role(2, RoleName.USER));
//        UserDto userDto = new UserDto("Gleb", "12345");
//        when(roleRepository.findByRole(RoleName.USER)).thenReturn(new Role(2, RoleName.USER));
//        assertEquals(user, userService.saveUser(userDto));
//    }
//}
