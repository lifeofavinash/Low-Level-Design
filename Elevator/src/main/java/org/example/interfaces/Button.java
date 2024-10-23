package org.example.interfaces;

import org.example.enums.ElevatorId;
import org.example.services.ElevatorController;
import org.example.utils.ElevatorControllerMapper;

import java.util.Map;

public interface Button {

    Map<ElevatorId, ElevatorController> elevatorControllerMap = ElevatorControllerMapper.getElevatorControllerMap();

    void submit(ElevatorId liftId, int targetFloor);
}
