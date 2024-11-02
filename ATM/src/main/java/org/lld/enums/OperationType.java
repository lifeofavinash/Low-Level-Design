package org.lld.enums;

import lombok.Getter;
import org.lld.interfaces.PerformOperation;
import org.lld.service.atmstate.operation.CashWithdraw;
import org.lld.service.atmstate.operation.DisplayAmount;
import org.lld.service.atmstate.operation.PrintBankStatement;

@Getter
public enum OperationType {

    CASH_WITHDRAW(new CashWithdraw()),
    BANK_STATEMENT(new PrintBankStatement()),
    PRINT_AMOUNT(new DisplayAmount());

    private final PerformOperation performOperation;

    OperationType(PerformOperation performOperation){
        this.performOperation = performOperation;
    }

}
