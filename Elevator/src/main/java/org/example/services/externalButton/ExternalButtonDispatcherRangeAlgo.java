package org.example.services.externalButton;

import org.example.enums.ElevatorId;
import org.example.services.ElevatorController;
import org.example.utils.ElevatorControllerMapper;

public class ExternalButtonDispatcherRangeAlgo extends ExternalButtonDispatcher {

    @Override
    ElevatorController getElevatorForTargetFloor(int targetFloor) {

        if(targetFloor >=0 && targetFloor <= 3) {
            return ElevatorControllerMapper.getElevatorControllerMap().get(ElevatorId.ELEVATOR_L1);
        }
        else if(targetFloor > 3 && targetFloor <= 5){
            return ElevatorControllerMapper.getElevatorControllerMap().get(ElevatorId.ELEVATOR_L2);
        }
        else {
            return ElevatorControllerMapper.getElevatorControllerMap().get(ElevatorId.ELEVATOR_L3);
        }
    }
}
