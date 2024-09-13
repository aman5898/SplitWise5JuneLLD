package org.scaler.splitwise5junelld.strategies;

import org.scaler.splitwise5junelld.models.Expense;
import org.scaler.splitwise5junelld.models.Transaction;

import java.util.List;

public interface SettleUpStrategy {
    List<Transaction> settleUp(List<Expense> expenses);
}
