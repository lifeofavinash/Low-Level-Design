package org.lld.service.atmstate.operation.withdraw;

import org.lld.enums.CurrencyType;
import org.lld.model.ATM;
import org.lld.service.atmstate.operation.CashWithdraw;

public class FiveHundredProcessor extends CashWithdraw {
    
    public FiveHundredProcessor(CashWithdraw nextProcessor) {
        super(nextProcessor);
    }

    @Override
    protected boolean getCashCount(ATM atm, long amount) {

        long requiredAmount = amount / CurrencyType.FIVE_HUNDRED.getAmount();

        if(atm.hasEnoughCash(requiredAmount, CurrencyType.FIVE_HUNDRED)) {
            amount = amount - (requiredAmount * CurrencyType.FIVE_HUNDRED.getAmount());
            atm.deductCurrencyFromATM(requiredAmount, CurrencyType.FIVE_HUNDRED);
        }
        else {
            amount = amount - (atm.getCashCount(CurrencyType.FIVE_HUNDRED) * CurrencyType.FIVE_HUNDRED.getAmount());
            atm.deductCurrencyFromATM(atm.getCashCount(CurrencyType.FIVE_HUNDRED), CurrencyType.ONE_HUNDRED);
        }

        if(amount > 0) {
            return super.getCashCount(atm, amount);
        }
        else {
            return true;
        }
    }
}
