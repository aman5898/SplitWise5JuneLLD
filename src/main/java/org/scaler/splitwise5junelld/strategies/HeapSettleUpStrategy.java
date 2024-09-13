package org.scaler.splitwise5junelld.strategies;


import org.scaler.splitwise5junelld.models.Expense;
import org.scaler.splitwise5junelld.models.Transaction;

import java.util.List;

public class HeapSettleUpStrategy implements SettleUpStrategy{
    @Override
    public List<Transaction> settleUp(List<Expense> expenses) {
        return List.of();
    }
    // Find Net Amount.
//    Create Two Heaps.
//    Always pick max of both sides, and settle one of the sides
}
