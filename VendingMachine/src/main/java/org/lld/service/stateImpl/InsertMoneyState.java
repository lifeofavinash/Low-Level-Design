package org.lld.service.stateImpl;

import org.lld.enums.Coin;
import org.lld.interfaces.State;
import org.lld.model.Item;
import org.lld.service.VendingMachine;

public class InsertMoneyState implements State {
    @Override
    public void clickInsertMoneyButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("This action can not be performed.");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) {

        vendingMachine.addCoin(coin);

        System.out.printf("Inserted %s Rs to vending machine%n", coin.getValue());

    }

    @Override
    public void clickCancelButton(VendingMachine vendingMachine) {

        vendingMachine.setCurrentState(new IdleState());
        vendingMachine.returnAllCoins();

    }

    @Override
    public void clickProductSelectionButton(VendingMachine vendingMachine) {

        vendingMachine.printTotalAmount();

        vendingMachine.setCurrentState(new SelectProductState());

        System.out.println("Please enter the shelf code to proceed...");
    }

    @Override
    public Item enterShelfCode(VendingMachine vendingMachine, int shelfCode) throws Exception {
        throw new Exception("This action can not be performed.");
    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine, Item item) throws Exception {
        throw new Exception("This action can not be performed.");
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, Item item, int shelfCode) throws Exception {
        throw new Exception("This action can not be performed.");
    }
}
