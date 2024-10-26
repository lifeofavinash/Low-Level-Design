package org.lld.service.stateImpl;

import org.lld.enums.Coin;
import org.lld.enums.ItemName;
import org.lld.interfaces.State;
import org.lld.model.Item;
import org.lld.service.VendingMachine;

public class SelectProductState implements State {

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
        vendingMachine.setCurrentState(new IdleState());
        vendingMachine.returnAllCoins();
    }

    @Override
    public void clickProductSelectionButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("This action can not be performed.");
    }

    @Override
    public Item enterShelfCode(VendingMachine vendingMachine, int shelfCode) throws Exception {

        Item item = vendingMachine.getInventoryManager().getItemFromShelf(shelfCode);

        if(item.getItemName().equals(ItemName.EMPTY)){
            throw new Exception("The selected shelf is empty, please try again with another item.");
        }

        System.out.printf("Item: %s of %s Rs selected!%n", item.getItemName(), item.getAmount());

        vendingMachine.setCurrentState(new DispenseProductState());
        return item;

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
