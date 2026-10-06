package com.naresh.splitwiseapp.commands;

public interface Command {
    boolean matches(String input);
    void execute(String input);
}
