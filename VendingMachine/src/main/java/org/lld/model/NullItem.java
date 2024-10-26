package org.lld.model;

import org.lld.enums.ItemName;

public class NullItem extends Item {

    public NullItem() {
        setItemName(ItemName.EMPTY);
        setAmount(0);
    }

}
