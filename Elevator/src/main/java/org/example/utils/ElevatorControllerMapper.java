package org.example.utils;

import lombok.Data;
import lombok.Getter;
import org.example.enums.ElevatorId;
import org.example.services.ElevatorController;

import java.util.HashMap;
import java.util.Map;

@Data
public class ElevatorControllerMapper {

    @Getter
    private static Map<ElevatorId, ElevatorController> elevatorControllerMap = new HashMap<>();

    public static void addElevatorController(ElevatorController elevatorController) {

        ElevatorId elevatorId = elevatorController.getElevator().getElevatorId();
        elevatorControllerMap.put(elevatorId, elevatorController);

    }

}
