package com.naresh.splitwiseapp.commands;

import com.naresh.splitwiseapp.controllers.UserController;
import com.naresh.splitwiseapp.dtos.RegisterUserRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class RegisterUserCommand implements Command{
    // Register vinsmokesanii 003 namisswwaan
    private UserController userController;
    @Autowired
    public RegisterUserCommand(UserController userController) {
        this.userController = userController;
    }
    @Override
    public boolean matches(String input) {
        List<String> inpWords = Arrays.stream(input.split(" ")).toList();
        if(inpWords.size() == 4 && inpWords.get(0).equalsIgnoreCase(CommandKeywords.REGISTER_USER )){
            return true;
        }

        return false;
    }
    @Override
    public void execute(String input) {
        List<String> inpWords = Arrays.stream(input.split(" ")).toList();


        String password = inpWords.get(1);
        String username = inpWords.get(3);
        String phoneNumber = inpWords.get(2);

        //call your controller and get your action done
        RegisterUserRequestDto registerUserRequestDto = new RegisterUserRequestDto();
        registerUserRequestDto.setPassword(password);
        registerUserRequestDto.setPhoneNumber(phoneNumber);
        registerUserRequestDto.setUserName(username);
        userController.registerUser(registerUserRequestDto);






    }
}
