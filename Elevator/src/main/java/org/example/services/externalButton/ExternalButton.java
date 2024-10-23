package org.example.services.externalButton;

import org.example.enums.ElevatorId;
import org.example.interfaces.Button;
import org.example.services.ElevatorController;

public class ExternalButton implements Button {

    @Override
    public void submit(ElevatorId liftId, int targetFloor) {
        ElevatorController elevatorController = elevatorControllerMap.get(liftId);
        elevatorController.addJob(targetFloor);
    }

}
