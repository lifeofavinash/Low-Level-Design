package org.example.utils;

public class ElevatorFloorValidator {

    public static boolean isFloorNumberValid(int targetFloorNumber, int currentFloorNumber) {

        return targetFloorNumber >= 0 && targetFloorNumber <= 6 && targetFloorNumber != currentFloorNumber;

    }

    public static boolean isFloorNumberValid(int targetFloorNumber) {

        return targetFloorNumber >= 0 && targetFloorNumber <= 6;

    }

}
