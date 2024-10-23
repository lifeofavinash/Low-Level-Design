package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Location {

    private String address;
    private String state;
    private String city;
    private int pincode;

}
