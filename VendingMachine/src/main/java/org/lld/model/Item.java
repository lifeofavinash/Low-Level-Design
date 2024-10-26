package org.lld.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.lld.enums.ItemName;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private ItemName itemName;
    private int amount;
}
