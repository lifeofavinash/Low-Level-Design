package org.lld.service.atmstate;

import org.lld.enums.OperationType;
import org.lld.interfaces.PerformOperation;
import org.lld.model.ATM;
import org.lld.model.Card;
import org.lld.service.ATMState;
import org.lld.service.atmstate.operation.CashWithdraw;
import org.lld.service.atmstate.operation.withdraw.FiveHundredProcessor;
import org.lld.service.atmstate.operation.withdraw.HundredProcessor;
import org.lld.service.atmstate.operation.withdraw.TwoThousandProcessor;

public class PerformOperationState extends ATMState {

    private final OperationType operationType;

    public PerformOperationState(OperationType operationType){
        this.operationType = operationType;
    }

    @Override
    public void performOperation(ATM atm, Card card) {

        PerformOperation performOperation = operationType.getPerformOperation();
        performOperation.perform(atm, card);

        atm.setAtmState(new IdleState());

    }

    @Override
    public void withdrawCash(ATM atm, Card card, long amount){

        PerformOperation performOperation = new CashWithdraw(new TwoThousandProcessor(new FiveHundredProcessor(new HundredProcessor(null))));
        performOperation.perform(atm, card, amount);

        card.deductAmountFromAccount(amount);
        atm.deductAmountFromATM(amount);

        atm.setAtmState(new IdleState());

    }

}
