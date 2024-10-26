package org.lld.service;

import lombok.Data;
import org.lld.enums.Coin;
import org.lld.interfaces.State;
import org.lld.model.Item;
import org.lld.service.stateImpl.IdleState;

import java.util.ArrayList;
import java.util.List;

@Data
public class VendingMachine {

    private State currentState;
    private List<Coin> coinList;
    private InventoryManager inventoryManager;

    public VendingMachine() {

        this.currentState = new IdleState();
        this.coinList = new ArrayList<>();
        this.inventoryManager = new InventoryManager();

    }

    public int getRemainingCoins(Item item) {
        int totalAmount = countTotalCoinsAmount();
        int itemAmount = item.getAmount();

        if(totalAmount < itemAmount)
        {
            return -1;
        }
        else {
            return totalAmount - itemAmount;
        }
    }

    public void addCoin(Coin coin){
        this.coinList.add(coin);
    }

    public void returnAllCoins() {

        this.coinList = new ArrayList<>();
        System.out.printf("Please collect %s amount in the coin collector.%n", countTotalCoinsAmount());

    }

    private int countTotalCoinsAmount(){

        int totalAmount = 0;
        for(Coin coin: coinList){
            totalAmount += coin.getValue();
        }

        return totalAmount;
    }

    public void printTotalAmount() {

        System.out.printf("Total amount inserted to inventory: %s Rs%n", countTotalCoinsAmount());

    }
}
