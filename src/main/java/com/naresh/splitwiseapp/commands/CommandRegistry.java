package com.naresh.splitwiseapp.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandRegistry {
    private List<Command> commands;
    @Autowired
    public CommandRegistry(RegisterUserCommand registerUserCommand) {
        commands = new ArrayList<>();
        //After this particular thing, this will ensure
        // putting all of things in one place
        // It is a prototype  Registry Design pattern basically
        // Registry--> A store of information
        // CommandRegistry--> It basically keeps all of the commands and provides a method to execute it.
        commands.add(registerUserCommand);


    }
    public void execute(String input){
        for(Command command : commands){
            if(command.matches(input)){
                command.execute(input);
                break;
            }
        }
    }
}
