package org.example.services.externalButton;

import org.example.enums.ElevatorId;
import org.example.services.ElevatorController;
import org.example.utils.ElevatorControllerMapper;

public class ExternalButtonDispatcherRoundRobin extends ExternalButtonDispatcher{

    private int counter = 0;

    @Override
    ElevatorController getElevatorForTargetFloor(int targetFloor) {

        int elevatorCount = ElevatorControllerMapper.getElevatorControllerMap().size();

        counter = (counter + 1) % elevatorCount;

        if(counter == 1) {
            return ElevatorControllerMapper.getElevatorControllerMap().get(ElevatorId.ELEVATOR_L1);
        }
        else if(counter == 2){
            return ElevatorControllerMapper.getElevatorControllerMap().get(ElevatorId.ELEVATOR_L2);
        }
        else {
            return ElevatorControllerMapper.getElevatorControllerMap().get(ElevatorId.ELEVATOR_L3);
        }
    }
}
