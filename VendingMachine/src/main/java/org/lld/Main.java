package org.lld;

import org.lld.enums.Coin;
import org.lld.enums.ItemName;
import org.lld.interfaces.State;
import org.lld.model.Item;
import org.lld.service.InventoryManager;
import org.lld.service.VendingMachine;

public class Main {
    public static void main(String[] args) {

        // Generate Inventory
        VendingMachine vendingMachine = new VendingMachine();
        generateInventory(vendingMachine);

        try {

            // Click insert money button
            State state = vendingMachine.getCurrentState();
            state.clickInsertMoneyButton(vendingMachine);

            // Insert coins
            state = vendingMachine.getCurrentState();
            state.insertCoin(vendingMachine, Coin.TEN);
            state.insertCoin(vendingMachine, Coin.TEN);
            state.insertCoin(vendingMachine, Coin.TEN);
            state.insertCoin(vendingMachine, Coin.FIVE);
            state.insertCoin(vendingMachine, Coin.FIVE);
            state.insertCoin(vendingMachine, Coin.ONE);

            // Click Product selection button
            state.clickProductSelectionButton(vendingMachine);

            // Add product code
            state = vendingMachine.getCurrentState();
            Item item = state.enterShelfCode(vendingMachine, 102);

            // Dispense product
            state = vendingMachine.getCurrentState();
            state.dispenseProduct(vendingMachine, item);


        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }


    }

    private static void generateInventory(VendingMachine vendingMachine) {

        for(int i=0; i<10; i++) {

            if(i < 3)
                vendingMachine.getInventoryManager().addItemToShelf(new Item(ItemName.COKE, 30), 100);
            else if(i < 5){
                vendingMachine.getInventoryManager().addItemToShelf(new Item(ItemName.MILKY_BAR, 10), 101);
            }
            else if(i < 8) {
                vendingMachine.getInventoryManager().addItemToShelf(new Item(ItemName.CHIPS, 5), 102);
            }
            else {
                vendingMachine.getInventoryManager().addItemToShelf(new Item(ItemName.COOKIES, 12), 103);
            }

        }

    }
}