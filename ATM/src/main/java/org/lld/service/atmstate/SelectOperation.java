package org.lld.service.atmstate;

import org.lld.enums.OperationType;
import org.lld.model.ATM;
import org.lld.model.Card;
import org.lld.service.ATMState;

public class SelectOperation extends ATMState {

    @Override
    public void setOperation(ATM atm, OperationType operationType) {
        atm.setAtmState(new PerformOperationState(operationType));
    }

    @Override
    public void exit(ATM atm) {
        atm.setAtmState(new IdleState());
    }
}
