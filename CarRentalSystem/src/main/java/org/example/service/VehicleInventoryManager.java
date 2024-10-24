package org.example.service;

import org.example.enums.RegistrationStatus;
import org.example.model.User;
import org.example.model.Vehicle;

import java.util.*;

public class VehicleInventoryManager {

    private Map<String, Vehicle> vehicleMap;
    private List<Registration> registraionList;
    private List<Vehicle> vehicleList;

    public VehicleInventoryManager() {
        this.vehicleMap = new HashMap<>();
        this.vehicleList = new ArrayList<>();
        this.registraionList = new ArrayList<>();
    }

    public List<Vehicle> getAvailableVehicles() {

        List<Vehicle> availableVehicles = new ArrayList<>();

        for(Vehicle vehicle: vehicleList){
            if(vehicle.isAvailable())
                availableVehicles.add(vehicle);
        }

        return availableVehicles;
    }

    public void addVehicleToInventory(Vehicle vehicle) {

        if(vehicleMap.containsKey(vehicle.getNumberPlate())){
            System.out.println("This Vehicle is already registered.");
        }
        else {
            vehicleList.add(vehicle);
            vehicleMap.put(vehicle.getNumberPlate(), vehicle);

            System.out.println("Vehicle added to inventory!");
        }
    }

    public void removeVehicleFromInventory(Vehicle vehicle) {

        // TODO: Remove Vehicle from vehicleList using Stream API

        vehicleMap.remove(vehicle.getNumberPlate());
    }

    public void registerVehicle(User user, Vehicle vehicle, Date startDate, Date endDate) {

        Registration registration = new Registration(UUID.randomUUID().toString(), user, vehicle, RegistrationStatus.IN_PROGRESS, startDate, endDate);

        registration.register();

        registraionList.add(registration);

        vehicle.setAvailable(false);

    }

    public void unregisterVehicle(String numberPlate) {

        // TODO: Use Stream API to remove registrations on the go

        Vehicle vehicle = getVehicleByNumberPlate(numberPlate);
        vehicle.setAvailable(true);

    }

    private Vehicle getVehicleByNumberPlate(String numberPlate) {
        return vehicleMap.get(numberPlate);
    }
}
