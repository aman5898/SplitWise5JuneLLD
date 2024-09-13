package org.scaler.splitwise5junelld.command;

import org.scaler.splitwise5junelld.controllers.SettleUpController;
import org.scaler.splitwise5junelld.dtos.ResponseStatus;
import org.scaler.splitwise5junelld.dtos.SettleUpGroupRequestDTO;
import org.scaler.splitwise5junelld.dtos.SettleUpGroupResponseDTO;
import org.scaler.splitwise5junelld.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class SettleUpGroupCommand implements Command{

    private SettleUpController settleUpController;

    @Autowired
    public SettleUpGroupCommand(SettleUpController
                                settleUpController){
        this.settleUpController = settleUpController;
    }

    @Override
    public boolean matches(String cmd) {
        List<String> words = List.of(cmd.split(" "));
        if(words.size()==2
        && words.get(0).equals("SettleUpGroup")){
            return true;
        }

        return false;
    }

//     SettleUpGroup 3
    @Override
    public void execute(String cmd) {
        List<String> words = List.of(cmd.split(" "));

        Long groupId = Long.parseLong(words.get(1));

        SettleUpGroupRequestDTO requestDTO =
                new SettleUpGroupRequestDTO();

        requestDTO.setGroupId(groupId);

        SettleUpGroupResponseDTO responseDTO =
                settleUpController.settleUpGroup(requestDTO);

        if(responseDTO.getResponseStatus().equals(ResponseStatus.SUCCESS)){
            System.out.println(responseDTO.getMessage());
            for(Transaction transaction:responseDTO.getTransactions()){
                System.out.println(transaction.getFrom().getName()+" should Pay "+
                        transaction.getAmount()+" to "+transaction.getTo().getName());
            }
        }else{
            System.out.println(responseDTO.getMessage());
        }
    }
}

//Terminal -> input -> SettleUpGroup 3 -> Response<-Controller -> Service
