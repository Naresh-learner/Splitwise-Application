package com.naresh.splitwiseapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserExpense extends BaseModel {
    @ManyToOne
    private Expense expense;
    @ManyToOne
    private User user;
    @Enumerated(EnumType.ORDINAL)
    private UserExpenseType userExpenseType;
    private int amount;
}
