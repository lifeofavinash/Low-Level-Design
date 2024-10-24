package org.example;

import org.example.enums.FuelType;
import org.example.enums.VehicleType;
import org.example.model.Location;
import org.example.model.User;
import org.example.model.Vehicle;
import org.example.service.RentalSystem;
import org.example.service.VehicleInventoryManager;
import org.example.util.Store;

import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        RentalSystem rentalSystem = new RentalSystem();

        // Generate Store
        Location storeALoc = Location.builder()
                .address("xyz")
                .state("Madhya Pradesh")
                .city("Jabalpur")
                .pincode(482008)
                .build();

        Store storeA = new Store(storeALoc, "StoreA");

        rentalSystem.addStore(storeA);

        // Vehicle creation

        Vehicle car = Vehicle.builder()
                .vehicleType(VehicleType.CAR)
                .numberPlate("MP20SC6654")
                .isElectric(false)
                .isAvailable(true)
                .fuelType(FuelType.PETROL)
                .millage(2000)
                .hasGear(true)
                .engineCC(250)
                .build();

        Vehicle bike = Vehicle.builder()
                .vehicleType(VehicleType.BIKE)
                .numberPlate("MP20SC4212")
                .isElectric(false)
                .isAvailable(true)
                .fuelType(FuelType.PETROL)
                .millage(2000)
                .hasGear(true)
                .engineCC(250)
                .vehicleRate(100)
                .build();

        // User Creation
        Location userLocation = Location.builder().address("xyz").state("Madhya Pradesh").city("Jabalpur").pincode(482004).build();
        User user = User.builder()
                .userId(UUID.randomUUID().toString())
                .name("Avinash Rao")
                .location(userLocation)
                .build();

        // Simulation

        Store requestedStore = rentalSystem.getStoreByName("StoreA");
        VehicleInventoryManager vehicleInventoryManager = requestedStore.getVehicleInventoryManager();

        vehicleInventoryManager.addVehicleToInventory(car);
        vehicleInventoryManager.addVehicleToInventory(bike);

        LocalDate endDate = LocalDate.now().plusDays(10);
        LocalDate startDate = LocalDate.now();

        vehicleInventoryManager.registerVehicle(user, car, Date.valueOf(startDate), Date.valueOf(endDate));

        System.out.println("Car registry: " + car.isAvailable());

    }
}