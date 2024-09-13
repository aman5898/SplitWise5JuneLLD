package org.scaler.splitwise5junelld.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandExecutor {
    private List<Command> commands;
    private SettleUpGroupCommand settleUpGroupCommand;

    @Autowired
    CommandExecutor(SettleUpGroupCommand settleUpGroupCommand){
        commands = new ArrayList<>();
        this.settleUpGroupCommand = settleUpGroupCommand;
        commands.add(settleUpGroupCommand);
    }

    public void addCommand(Command command){
        commands.add(command);
    }

    public void execute(String cmd){
        for(Command command:commands){
            if(command.matches(cmd)){
                command.execute(cmd);
            }
        }
    }
}
