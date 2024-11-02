package org.lld.service.atmstate.operation;

import org.lld.interfaces.PerformOperation;
import org.lld.model.ATM;
import org.lld.model.Card;

public class DisplayAmount implements PerformOperation {

    @Override
    public void perform(ATM atm, Card card) {

        System.out.printf("The available amount is: %s%n", card.getBankAccount().getAmount());

    }
}
