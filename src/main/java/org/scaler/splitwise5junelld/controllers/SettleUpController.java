package org.scaler.splitwise5junelld.controllers;

import org.scaler.splitwise5junelld.dtos.ResponseStatus;
import org.scaler.splitwise5junelld.dtos.SettleUpGroupRequestDTO;
import org.scaler.splitwise5junelld.dtos.SettleUpGroupResponseDTO;
import org.scaler.splitwise5junelld.models.Transaction;
import org.scaler.splitwise5junelld.services.SettleUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SettleUpController {

    private SettleUpService settleUpService;

    @Autowired
    public  SettleUpController (SettleUpService settleUpService){
        this.settleUpService = settleUpService;
    }

    public SettleUpGroupResponseDTO settleUpGroup(SettleUpGroupRequestDTO request){
        SettleUpGroupResponseDTO response = new SettleUpGroupResponseDTO();

        try{
            List<Transaction> transactionList = settleUpService.
                    settleUpGroup(request.getGroupId());

            response.setTransactions(transactionList);
            response.setResponseStatus(ResponseStatus.SUCCESS);
            response.setMessage("Transactions succesfully Generated");
        }catch(Exception ex){
            response.setResponseStatus(ResponseStatus.FAILURE);
            response.setMessage(ex.getMessage());
        }

        return response;
    }
}
