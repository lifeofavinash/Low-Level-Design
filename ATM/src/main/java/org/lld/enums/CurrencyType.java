package org.lld.enums;

import lombok.Getter;

@Getter
public enum CurrencyType {

    TWO_THOUSAND(2000),
    FIVE_HUNDRED(500),
    ONE_HUNDRED(100);

    private final int amount;

    CurrencyType(int amount) {
        this.amount = amount;
    }

}
