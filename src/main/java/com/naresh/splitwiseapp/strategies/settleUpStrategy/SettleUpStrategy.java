package com.naresh.splitwiseapp.strategies.settleUpStrategy;

import com.naresh.splitwiseapp.models.Expense;

import java.util.List;

public interface SettleUpStrategy {
    List<Transaction>settle(List<Expense> expenses);

}
