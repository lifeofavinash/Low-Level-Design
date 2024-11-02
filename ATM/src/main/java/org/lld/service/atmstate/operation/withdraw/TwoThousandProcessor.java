package org.lld.service.atmstate.operation.withdraw;

import org.lld.enums.CurrencyType;
import org.lld.model.ATM;
import org.lld.service.atmstate.operation.CashWithdraw;

public class TwoThousandProcessor extends CashWithdraw {


    public TwoThousandProcessor(CashWithdraw nextProcessor) {
        super(nextProcessor);
    }

    @Override
    protected boolean getCashCount(ATM atm, long amount) {

        long requiredAmount = amount / CurrencyType.TWO_THOUSAND.getAmount();

        if(atm.hasEnoughCash(requiredAmount, CurrencyType.TWO_THOUSAND)) {
            amount = amount - (requiredAmount * CurrencyType.TWO_THOUSAND.getAmount());
            atm.deductCurrencyFromATM(requiredAmount, CurrencyType.TWO_THOUSAND);
        }
        else {
            amount = amount - (atm.getCashCount(CurrencyType.TWO_THOUSAND) * CurrencyType.TWO_THOUSAND.getAmount());
            atm.deductCurrencyFromATM(atm.getCashCount(CurrencyType.TWO_THOUSAND), CurrencyType.TWO_THOUSAND);
        }

        if(amount > 0) {
            return super.getCashCount(atm, amount);
        }

        return true;

    }
}
