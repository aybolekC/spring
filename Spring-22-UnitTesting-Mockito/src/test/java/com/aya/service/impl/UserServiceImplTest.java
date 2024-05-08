package com.aya.service.impl;

import com.aya.repository.UserRepository;
import com.aya.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.inOrder;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    void deleteByUserName(){

        userService.deleteByUserName("grace@employee.com");
//        verify(userRepository).deleteByUserName("grace@employee.com");

//        verify(userRepository, times(1)).deleteByUserName("grace@employee.com");
//        verify(userRepository, atLeastOnce()).deleteByUserName("grace@employee.com");
////        verify(userRepository, atLeast(5)).deleteByUserName("grace@employee.com");
//        verify(userRepository, atMost(5)).deleteByUserName("grace@employee.com");
//        verify(userRepository, atMostOnce()).deleteByUserName("grace@employee.com");

        InOrder inOrder=inOrder(userRepository);
        inOrder.verify(userRepository).deleteByUserName("grace@employee.com");
        inOrder.verify(userRepository).findAll();



    }

}