package com.naresh.splitwiseapp.services;

import com.naresh.splitwiseapp.exceptions.UserAlreadyExistsException;
import com.naresh.splitwiseapp.models.User;
import com.naresh.splitwiseapp.models.UserStatus;
import com.naresh.splitwiseapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService {
    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(String userName, String phoneNumber, String password) throws UserAlreadyExistsException {
        //
        Optional<User> userOptional = userRepository.findByPhone(phoneNumber);
        if(userOptional.isPresent()){
            if(userOptional.get().getUserStatus().equals(UserStatus.ACTIVE)){
                throw new UserAlreadyExistsException();
            } else {
                User user = userOptional.get();
                user.setUserStatus(UserStatus.ACTIVE);
                user.setName(userName);
                user.setPassword(password);
                user.setPhone(phoneNumber);
                userRepository.save(user);
                return user;
            }

        }
        User user = new User();
        user.setName(userName);
        user.setPassword(password);
        user.setPhone(phoneNumber);
        user.setUserStatus(UserStatus.ACTIVE);
        userRepository.save(user);




        // A service returns a model
        return user;
    }


}
//Method-1: ExpenseController
//M2: splitwise.com/api/settleUp -> SettleUpController
