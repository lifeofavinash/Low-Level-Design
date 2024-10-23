package org.example.services.externalButton;

import org.example.services.ElevatorController;
import org.example.utils.ElevatorFloorValidator;

public abstract class ExternalButtonDispatcher {

    protected ExternalButton externalButton;

    public ExternalButtonDispatcher() {
        this.externalButton = new ExternalButton();
    }

    public void moveTo(int targetFloor) {

        if(ElevatorFloorValidator.isFloorNumberValid(targetFloor)) {
            ElevatorController elevatorController = getElevatorForTargetFloor(targetFloor);

            externalButton.submit(elevatorController.getElevator().getElevatorId(), targetFloor);
        }
        else{
            System.out.println("Please provide a valid floor number!");
        }

    }
    abstract ElevatorController getElevatorForTargetFloor(int targetFloor);

}
