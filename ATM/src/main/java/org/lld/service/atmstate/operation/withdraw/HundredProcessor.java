package org.lld.service.atmstate.operation.withdraw;

import org.lld.enums.CurrencyType;
import org.lld.model.ATM;
import org.lld.service.atmstate.operation.CashWithdraw;

public class HundredProcessor extends CashWithdraw {
    
    public HundredProcessor(CashWithdraw nextProcessor) {
        super(nextProcessor);
    }

    @Override
    protected boolean getCashCount(ATM atm, long amount) {

        long requiredAmount = amount / CurrencyType.ONE_HUNDRED.getAmount();

        if(atm.hasEnoughCash(requiredAmount, CurrencyType.ONE_HUNDRED)) {
            amount = amount - (requiredAmount * CurrencyType.ONE_HUNDRED.getAmount());
            atm.deductCurrencyFromATM(requiredAmount, CurrencyType.ONE_HUNDRED);
        }
        else {
            amount = amount - (atm.getCashCount(CurrencyType.ONE_HUNDRED) * CurrencyType.ONE_HUNDRED.getAmount());
            atm.deductCurrencyFromATM(atm.getCashCount(CurrencyType.ONE_HUNDRED), CurrencyType.TWO_THOUSAND);
        }

        if(amount > 0) {
            return super.getCashCount(atm, amount);
        }

        return false;

    }
}
