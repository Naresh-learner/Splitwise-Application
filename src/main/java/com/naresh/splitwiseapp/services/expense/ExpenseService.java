package com.naresh.splitwiseapp.services.expense;

import com.naresh.splitwiseapp.models.Expense;
import com.naresh.splitwiseapp.models.User;
import com.naresh.splitwiseapp.models.UserExpense;
import com.naresh.splitwiseapp.repositories.UserExpenseRepository;
import com.naresh.splitwiseapp.repositories.UserRepository;
import com.naresh.splitwiseapp.strategies.settleUpStrategy.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ExpenseService {
    private UserRepository userRepository;
    private UserExpenseRepository userExpenseRepository;
    @Autowired
    public ExpenseService(UserRepository userRepository, UserExpenseRepository userExpenseRepository){
        this.userRepository = userRepository;
        this.userExpenseRepository = userExpenseRepository;
    }


    public Transaction settleUpUser(Long userId){

        // what are the all of the expenses of this user
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()){
            //throw an Exception
            return null;
        }
        List<UserExpense> userExpenses = userExpenseRepository.findAllByUser(userOptional.get());
        List<Expense> expensesInvolvingUser = new ArrayList<>();
        for(UserExpense userExpense : userExpenses){
            expensesInvolvingUser.add(userExpense.getExpense());
        }



        return null;
    }
}
