package org.lld.service.atmstate;

import org.lld.enums.OperationType;
import org.lld.model.ATM;
import org.lld.model.Card;
import org.lld.service.ATMState;

public class InsertCardState extends ATMState {

    @Override
    public boolean authenticateCard(ATM atm, Card card, int pin) {

        if(card.getPinNumber() == pin) {
            atm.setAtmState(new SelectOperation());
            return true;
        }
        else
        {
            System.out.printf("Entered PIN is incorrect");
            atm.setAtmState(new IdleState());
            return false;
        }

    }

    @Override
    public void exit(ATM atm) {
        atm.setAtmState(new IdleState());
    }
}
