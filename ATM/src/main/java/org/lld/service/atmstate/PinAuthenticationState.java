package org.lld.service.atmstate;

import org.lld.enums.OperationType;
import org.lld.model.ATM;
import org.lld.model.Card;
import org.lld.service.ATMState;

public class PinAuthenticationState extends ATMState {
    @Override
    public void insertCard(ATM atm, Card card) {

    }

    @Override
    public boolean authenticateCard(ATM atm, Card card) {
        return false;
    }

    @Override
    public void setOperation(ATM atm, OperationType operationType) {

    }

    @Override
    public void performOperation(ATM atm) {

    }

    @Override
    public void exit(ATM atm) {

    }
}
