package com.naresh.splitwiseapp.controllers;

import com.naresh.splitwiseapp.dtos.RegisterUserRequestDto;
import com.naresh.splitwiseapp.dtos.RegisterUserResponseDto;
import com.naresh.splitwiseapp.exceptions.UserAlreadyExistsException;
import com.naresh.splitwiseapp.models.User;
import com.naresh.splitwiseapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
   //  A controller methods return DTOs
    public RegisterUserResponseDto registerUser(RegisterUserRequestDto registerUserRequestDto) {
        // this calls a service
        User user;
        RegisterUserResponseDto registerUserResponseDto = new RegisterUserResponseDto();
        try{
            user = userService.registerUser(
                    registerUserRequestDto.getUserName(),
                    registerUserRequestDto.getPhoneNumber(),
                    registerUserRequestDto.getPassword()
            );
            //RegisterUserResponseDto registerUserResponseDto = new RegisterUserResponseDto();
            registerUserResponseDto.setUserId(user.getId());
            registerUserResponseDto.setStatus("SUCCESS");
            registerUserResponseDto.setMessage("User registered successfully");
            return registerUserResponseDto;

        } catch (UserAlreadyExistsException userAlreadyExistsException){
            //RegisterUserResponseDto registerUserResponseDto = new RegisterUserResponseDto();
            registerUserResponseDto.setStatus("FAILURE");
            registerUserResponseDto.setMessage(userAlreadyExistsException.getMessage());
        }





        return registerUserResponseDto;
    }

}
