package org.lld.service.atmstate.operation;

import org.lld.interfaces.PerformOperation;
import org.lld.model.ATM;
import org.lld.model.Card;

public class PrintBankStatement implements PerformOperation {

    @Override
    public void perform(ATM atm, Card card) {

        System.out.println("Printing bank statement...");

        // TODO: Create a bank statement object and call printer API

    }
}
