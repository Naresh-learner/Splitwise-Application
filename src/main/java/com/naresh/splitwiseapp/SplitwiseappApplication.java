package com.naresh.splitwiseapp;

import com.naresh.splitwiseapp.commands.Command;
import com.naresh.splitwiseapp.commands.CommandRegistry;
import com.naresh.splitwiseapp.commands.RegisterUserCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class SplitwiseappApplication implements CommandLineRunner {
    private Scanner scanner ;
    private CommandRegistry commandRegistry;
    @Autowired
    public SplitwiseappApplication(CommandRegistry commandRegistry) {
        scanner = new Scanner(System.in);
        this.commandRegistry = commandRegistry;
//        commands = new ArrayList<>();
//        commands.add(new RegisterUserCommand());
//        commands.add(new UpdateProfileCommand());
//        commands.add(new SettleUpUserCommand());
        /// violating SRP principle

    }
    @Override
    public void run(String... args) throws Exception {
       while(true){
           System.out.println("Tell what do you want to do");
           String input = scanner.nextLine();
           commandRegistry.execute(input);



       }

    }
    public static void main(String[] args) {
        SpringApplication.run(SplitwiseappApplication.class, args);
    }


}
