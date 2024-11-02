package org.lld.service.atmstate;

import org.lld.enums.OperationType;
import org.lld.model.ATM;
import org.lld.model.Card;
import org.lld.service.ATMState;

public class IdleState extends ATMState {

    @Override
    public void insertCard(ATM atm, Card card) {
        atm.setAtmState(new InsertCardState());
    }
}
