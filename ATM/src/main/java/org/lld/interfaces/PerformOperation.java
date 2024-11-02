package org.lld.interfaces;

import org.lld.model.ATM;
import org.lld.model.Card;

public abstract class PerformOperation {

    public void perform(ATM atm, Card card){
        System.out.println("This operation is not permitted!");
    }

    public boolean perform(ATM atm, Card card, long amount) {
        System.out.println("This operation is not permitted!");
        return false;
    }

}
