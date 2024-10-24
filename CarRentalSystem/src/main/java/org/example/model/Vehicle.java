package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enums.FuelType;
import org.example.enums.VehicleType;

@Data
@AllArgsConstructor
@Builder
public class Vehicle {
    private String numberPlate;
    private int engineCC;
    private boolean hasGear;
    private boolean isElectric;
    private int millage;
    private VehicleType vehicleType;
    private FuelType fuelType;
    private int vehicleRate;
    private boolean isAvailable;

}
