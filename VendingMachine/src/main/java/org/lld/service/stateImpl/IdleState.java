package org.lld.service.stateImpl;

import org.lld.enums.Coin;
import org.lld.interfaces.State;
import org.lld.model.Item;
import org.lld.service.VendingMachine;

public class IdleState implements State {

    @Override
    public void clickInsertMoneyButton(VendingMachine vendingMachine) {
        vendingMachine.setCurrentState(new InsertMoneyState());
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
    public void dispenseProduct(VendingMachine vendingMachine, Item item) throws Exception {
        throw new Exception("This action can not be performed.");
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, Item item, int shelfCode) {
        boolean isItemAdded = vendingMachine.getInventoryManager().addItemToShelf(item, shelfCode);

        if(isItemAdded)
            System.out.printf("Item %s added to shelf %s%n", item.getItemName(), shelfCode);
        else
            System.out.println("Can not add the item, shelf is not empty!");
    }
}
