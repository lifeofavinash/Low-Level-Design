package org.lld.model;

import lombok.Data;

@Data
public class BankAccount {

    private long amount;

    public BankAccount(long amount) {
        this.amount = amount;
    }

    public void updateAmount(long reduceAmount) {
        this.amount = amount - reduceAmount;
    }

}
