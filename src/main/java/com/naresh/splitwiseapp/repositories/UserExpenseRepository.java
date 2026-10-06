package com.naresh.splitwiseapp.repositories;

import com.naresh.splitwiseapp.models.Expense;
import com.naresh.splitwiseapp.models.User;
import com.naresh.splitwiseapp.models.UserExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserExpenseRepository extends JpaRepository<UserExpense,Long> {
   List<UserExpense> findAllByUser(User user);
   List<UserExpense> findAllByExpenseIn(List<Expense> expenses);

}
