package org.lld.service.atmstate.operation;

import org.lld.interfaces.PerformOperation;
import org.lld.model.ATM;
import org.lld.model.Card;

public class CashWithdraw extends PerformOperation {

    private final CashWithdraw nextProcessor;

    public CashWithdraw(CashWithdraw nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    @Override
    public boolean perform(ATM atm, Card card, long amount) {

        if(atm.getAmount() < amount) {
            System.out.println("Insufficient amount int ATM, please try again later.");
            return false;
        }
        else if(card.getBankAccount().getAmount() < amount) {
            System.out.println("Your account has insufficient balance, please try again.");
            return false;
        }
        else {
            return getCashCount(atm, amount);
        }

    }

    protected boolean getCashCount(ATM atm, long amount) {

        if(nextProcessor != null) {
            return nextProcessor.getCashCount(atm, amount);
        }
        else {
            System.out.println("Not enough cash for withdraw!");
            return false;
        }
    }
}
