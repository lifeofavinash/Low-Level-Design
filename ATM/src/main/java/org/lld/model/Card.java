package org.lld.model;

import lombok.Data;

@Data
public class Card {

    private final long accountNumber;
    private final int pinNumber;
    private final int cvv;
    private BankAccount bankAccount;

    public Card(long accountNumber, int pinNumber, int cvv) {
        this.accountNumber = accountNumber;
        this.pinNumber = pinNumber;
        this.cvv = cvv;
    }

    public void deductAmountFromAccount(long amount) {
        bankAccount.updateAmount(amount);
    }

}
