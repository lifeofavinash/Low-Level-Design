package org.lld.model;

import lombok.Data;
import org.lld.enums.CurrencyType;
import org.lld.service.ATMState;
import org.lld.service.atmstate.IdleState;

@Data
public class ATM {

    private ATMState atmState;
    private long amount;
    private int twoThousandNotes;
    private int fiveHundredNotes;
    private int hundredNotes;

    public ATM(long amount, int twoThousandNotes, int fiveHundredNotes, int hundredNotes) {

        this.amount = amount;
        this.twoThousandNotes = twoThousandNotes;
        this.fiveHundredNotes = fiveHundredNotes;
        this.hundredNotes = hundredNotes;
        this.atmState = new IdleState();

    }

    public boolean hasEnoughCash(long requiredAmount, CurrencyType currencyType) {

        if(currencyType.equals(CurrencyType.TWO_THOUSAND)) {
            return twoThousandNotes >= requiredAmount;
        }
        else if(currencyType.equals(CurrencyType.FIVE_HUNDRED)) {
            return fiveHundredNotes >= requiredAmount;
        }
        else {
            return hundredNotes >= requiredAmount;
        }
    }

    public long getCashCount(CurrencyType currencyType) {

        if(currencyType.equals(CurrencyType.TWO_THOUSAND)) {
            return twoThousandNotes;
        }
        else if(currencyType.equals(CurrencyType.FIVE_HUNDRED)) {
            return fiveHundredNotes;
        }
        else {
            return hundredNotes;
        }

    }

    public void deductCurrencyFromATM(long currencyCount, CurrencyType currencyType) {

        if(currencyType.equals(CurrencyType.TWO_THOUSAND)) {
            this.twoThousandNotes -= (int) currencyCount;
        }
        else if(currencyType.equals(CurrencyType.FIVE_HUNDRED)) {
            this.fiveHundredNotes -= (int) currencyCount;
        }
        else {
            this.hundredNotes -= (int) currencyCount;
        }

    }

    public void deductAmountFromATM(long amount) {

        this.amount -= amount;

    }
}
