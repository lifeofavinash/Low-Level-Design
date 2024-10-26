package org.lld.service;

import lombok.Data;
import org.lld.model.Item;
import org.lld.model.NullItem;
import org.lld.model.Shelf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class InventoryManager {

    private List<Shelf> shelves;
    private Map<Integer, Shelf> shelfMap;

    public InventoryManager(){

        this.shelves = new ArrayList<>();
        this.shelfMap = new HashMap<>();

    }

    public void addShelf(Shelf shelf){

        shelves.add(shelf);
        shelfMap.put(shelf.getShelfCode(), shelf);

    }

    public boolean setShelfEmpty(int shelfCode) {
        if(shelfMap.containsKey(shelfCode)){

            Shelf shelf = shelfMap.get(shelfCode);

            shelf.setShelfEmpty();
            return true;

        }
        else{
            return false;
        }
    }

    public Item getItemFromShelf(int shelfCode){

        if(shelfMap.containsKey(shelfCode)) {

            Shelf shelf = shelfMap.get(shelfCode);

            shelf.setShelfEmpty();
            return shelf.getItem();

        }
        else{
            return new NullItem();
        }

    }

    public boolean addItemToShelf(Item item, int shelfCode) {

        if(!shelfMap.containsKey(shelfCode)) {

            Shelf shelf = new Shelf();

            shelf.addItem(item);
            shelfMap.put(shelfCode, shelf);

            System.out.printf("Item %s added to %s shelf%n", item.getItemName(), shelf.getShelfCode());

            return true;
        }

        return false;
    }
}
