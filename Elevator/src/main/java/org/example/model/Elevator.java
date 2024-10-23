package org.example.model;

import lombok.Data;
import org.example.enums.Direction;
import org.example.enums.ElevatorId;
import org.example.enums.Status;
import org.example.services.internalButton.InternalButton;
import org.example.utils.ElevatorFloorValidator;

@Data
public class Elevator {

    private ElevatorId elevatorId;
    private int currentFloorNumber;
    private Display display;
    private Direction direction;
    private InternalButton internalButton;
    private Status status;

    public Elevator(ElevatorId elevatorId, int initialFloorNumber, Direction initialDirection) {

        this.elevatorId = elevatorId;
        this.currentFloorNumber = initialFloorNumber;
        this.display = new Display();
        this.internalButton = new InternalButton();
        this.status = Status.STATIC;
        this.direction = initialDirection;
    }

    public void moveTo(int targetFloor) {

        if(ElevatorFloorValidator.isFloorNumberValid(targetFloor, currentFloorNumber))
            internalButton.submit(elevatorId, targetFloor);
        else
            System.out.println("Please provide a valid floor number!");
    }
}
