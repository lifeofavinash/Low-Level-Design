package org.lld.interfaces;

import org.lld.enums.Coin;
import org.lld.model.Item;
import org.lld.service.VendingMachine;

import java.util.concurrent.ExecutionException;

public interface State {

    void clickInsertMoneyButton(VendingMachine vendingMachine) throws Exception;
    void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception;
    void clickCancelButton(VendingMachine vendingMachine) throws Exception;
    void clickProductSelectionButton(VendingMachine vendingMachine) throws Exception;
    Item enterShelfCode(VendingMachine vendingMachine, int shelfCode) throws Exception;
    void dispenseProduct(VendingMachine vendingMachine, Item item) throws Exception;
    void updateInventory(VendingMachine vendingMachine, Item item, int shelfCode) throws Exception;

}
