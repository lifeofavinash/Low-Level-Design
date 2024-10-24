package org.example.util;

import lombok.Data;
import org.example.model.Location;
import org.example.service.VehicleInventoryManager;

@Data
public class Store {

    private VehicleInventoryManager vehicleInventoryManager;
    private Location location;
    private boolean isOpen;
    private String storeName;

    public Store(Location location, String storeName) {

        this.location = location;
        this.storeName = storeName;
        this.isOpen = true;
        this.vehicleInventoryManager = new VehicleInventoryManager();

    }

}
