package org.scaler.splitwise5junelld;

import org.scaler.splitwise5junelld.command.CommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Scanner;


@SpringBootApplication
@EnableJpaAuditing
public class SplitWise5JuneLldApplication implements CommandLineRunner {

    @Autowired
    CommandExecutor commandExecutor;
    private Scanner scn = new Scanner(System.in);
    @Override
    public void run(String... args) throws Exception {
        while(true){
            System.out.println("Enter Command");
            String command = scn.nextLine();
            commandExecutor.execute(command);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(SplitWise5JuneLldApplication.class, args);

    }

}


//- Execute a use Case Settle Up Group
//- Implement Command Pattern

//SettleUpGroup 3



