package org.example.service;

import org.example.model.Vehicle;
import org.example.model.VehicleCount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VehicleInventoryManager {

    private Map<String, VehicleCount> vehicleMap;
    private List<Registration> registraionList;

    public VehicleInventoryManager() {
        this.vehicleMap = new HashMap<>();
        this.registraionList = new ArrayList<>();
    }

    public void addVehicleToInventory(Vehicle vehicle) {

        if(vehicleMap.containsKey(vehicle.getNumberPlate())) {
            VehicleCount vehicleCount = vehicleMap.get(vehicle.getNumberPlate());
            vehicleCount.setCount(vehicleCount.getCount() + 1);

            vehicleMap.put(vehicle.getNumberPlate(), vehicleCount);
        }
        else {
            this.vehicleMap.put(vehicle.getNumberPlate(), new VehicleCount(vehicle, 1));
        }
    }

    public void registerVehicle(String numberPlate) {
        Vehicle vehicle = getVehicleByNumberPlate(numberPlate);

        // TODO: Create a Registration and add it to the list

    }

    private Vehicle getVehicleByNumberPlate(String numberPlate) {
        return vehicleMap.get(numberPlate).getVehicle();
    }
}
