package org.example;

import org.example.enums.Direction;
import org.example.enums.ElevatorId;
import org.example.model.Elevator;
import org.example.services.ElevatorController;
import org.example.services.externalButton.ExternalButtonDispatcher;
import org.example.services.externalButton.ExternalButtonDispatcherRoundRobin;
import org.example.utils.ElevatorControllerMapper;

public class Main {
    public static void main(String[] args) {

        Elevator elevatorL1 = new Elevator(ElevatorId.ELEVATOR_L1, 0, Direction.UP);
        Elevator elevatorL2 = new Elevator(ElevatorId.ELEVATOR_L2, 0, Direction.UP);
        Elevator elevatorL3 = new Elevator(ElevatorId.ELEVATOR_L3, 0, Direction.UP);

        ElevatorController elevatorControllerL1 = new ElevatorController(elevatorL1);
        ElevatorController elevatorControllerL2 = new ElevatorController(elevatorL2);
        ElevatorController elevatorControllerL3 = new ElevatorController(elevatorL3);

        //Configure Elevator Mapper
        ElevatorControllerMapper.addElevatorController(elevatorControllerL1);
        ElevatorControllerMapper.addElevatorController(elevatorControllerL2);
        ElevatorControllerMapper.addElevatorController(elevatorControllerL3);

        // External Button Dispatcher configuration
        ExternalButtonDispatcher externalButtonDispatcher = new ExternalButtonDispatcherRoundRobin();

        System.out.println(elevatorL1);
        System.out.println(elevatorL2);
        System.out.println(elevatorL3);

        // Consider Floor range is 0 <-> 6
        // Press internal buttons
        elevatorL1.moveTo(6);
        elevatorL2.moveTo(5);
        elevatorL1.moveTo(3);
        elevatorL1.moveTo(0);

        // Press external button
        externalButtonDispatcher.moveTo(6);
        externalButtonDispatcher.moveTo(3);
        externalButtonDispatcher.moveTo(4);
        externalButtonDispatcher.moveTo(0);


    }
}