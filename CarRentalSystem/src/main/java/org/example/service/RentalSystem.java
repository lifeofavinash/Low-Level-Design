package org.example.service;

import lombok.Data;
import org.example.util.Store;

import java.util.ArrayList;
import java.util.List;

@Data
public class RentalSystem {

    private List<Store> storeList;

    public RentalSystem() {
        this.storeList = new ArrayList<>();
    }

    public Store getStoreByName(String storeName) {

        for(Store store: storeList){
            if(store.getStoreName().equals(storeName))
                return store;
        }

        return null;

    }

    public void addStore(Store store) {
        this.storeList.add(store);
    }

    public void removeStore(Store store) {

        // TODO: Add Stream API to remove store from here

    }

}
