package com.naresh.splitwiseapp.strategies.settleUpStrategy;

import com.naresh.splitwiseapp.models.Expense;
import com.naresh.splitwiseapp.models.UserExpense;
import com.naresh.splitwiseapp.repositories.UserExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class TwoSetsSettleUpStrategy implements SettleUpStrategy{
    private UserExpenseRepository userExpenseRepository;

    @Autowired
    public TwoSetsSettleUpStrategy(UserExpenseRepository userExpenseRepository) {
        this.userExpenseRepository = userExpenseRepository;
    }
    @Override
    public List<Transaction> settle(List<Expense> expenses) {

        List<UserExpense> allUserExpenseForTheseExpenses = userExpenseRepository.findAllByExpenseIn(expenses);

        return null;
    }
}
