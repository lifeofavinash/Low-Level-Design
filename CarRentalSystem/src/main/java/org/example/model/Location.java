package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Location {

    private String address;
    private String state;
    private String city;
    private int pincode;

}
