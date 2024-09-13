package org.scaler.splitwise5junelld.dtos;

import lombok.Getter;
import lombok.Setter;
import org.scaler.splitwise5junelld.models.Transaction;

import java.util.List;

@Getter
@Setter
public class SettleUpGroupResponseDTO {
    private List<Transaction> transactions;
    private ResponseStatus responseStatus;
    private String message;
}

//aman -> kayvya ->  30
//puneet -> Ashwin -> x
