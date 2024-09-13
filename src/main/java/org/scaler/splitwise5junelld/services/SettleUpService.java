package org.scaler.splitwise5junelld.services;

import org.scaler.splitwise5junelld.models.Expense;
import org.scaler.splitwise5junelld.models.Group;
import org.scaler.splitwise5junelld.models.Transaction;
import org.scaler.splitwise5junelld.repositories.GroupRespository;
import org.scaler.splitwise5junelld.strategies.GeneralSettleUpStrategy;
import org.scaler.splitwise5junelld.strategies.SettleUpStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SettleUpService {
    private GroupRespository groupRespository;
    private SettleUpStrategy settleUpStrategy;


    @Autowired
    SettleUpService(GroupRespository groupRespository){
        this.groupRespository = groupRespository;
//        ideally should be done by factory based on user config or what admin decides
        this.settleUpStrategy = new GeneralSettleUpStrategy();
    }

    public List<Transaction> settleUpGroup(Long groupId){
//        1. Get The group
        Optional<Group> groupOptional = groupRespository.findById(groupId);
        if(groupOptional.isEmpty()){
            throw new RuntimeException("Group Not Found");
        }
        Group group = groupOptional.get();
        // 2. Get all of thh expense of the group
        List<Expense> expenses = group.getExpenses();
//        3. Call the algo and Pass expenses to get the transactions
        return settleUpStrategy.settleUp(expenses);
    }
}
