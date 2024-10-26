package org.lld.service.stateImpl;

import org.lld.enums.Coin;
import org.lld.interfaces.State;
import org.lld.model.Item;
import org.lld.service.VendingMachine;

public class DispenseProductState implements State {

    @Override
    public void clickInsertMoneyButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("This action can not be performed.");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        throw new Exception("This action can not be performed.");
    }

    @Override
    public void clickCancelButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("This action can not be performed.");
    }

    @Override
    public void clickProductSelectionButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("This action can not be performed.");
    }

    @Override
    public Item enterShelfCode(VendingMachine vendingMachine, int shelfCode) throws Exception {
        throw new Exception("This action can not be performed.");
    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine, Item item) throws Exception{

        int remainingAmount = vendingMachine.getRemainingCoins(item);

        if(remainingAmount == -1) {
            vendingMachine.returnAllCoins();
            throw new Exception("Amount not suffecient please try again!");
        }

        System.out.printf("Please collect %s from the coin collector%n", remainingAmount);

        vendingMachine.setCurrentState(new IdleState());
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, Item item, int shelfCode) throws Exception {
        throw new Exception("This action can not be performed.");
    }
}
