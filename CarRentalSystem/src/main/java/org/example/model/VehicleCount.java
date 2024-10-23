package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VehicleCount {
    private Vehicle vehicle;
    private int count;
}
