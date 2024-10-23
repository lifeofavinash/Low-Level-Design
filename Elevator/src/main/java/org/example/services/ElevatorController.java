package org.example.services;

import lombok.Data;
import org.example.enums.Direction;
import org.example.interfaces.ElevatorQueueSubscriber;
import org.example.model.Elevator;

import java.util.ArrayList;

@Data
public class ElevatorController implements ElevatorQueueSubscriber {

    public static final int ELEVATOR_MOVING_DELAY = 2000;
    private Elevator elevator;
    private ElevatorQueue elevatorQueue;

    public ElevatorController(Elevator elevator) {
        this.elevator = elevator;
        this.elevatorQueue = new ElevatorQueue();

        // Subscribe to ElevatorQueue
        elevatorQueue.subscribe(this);
    }

    @Override
    public void move() {
        try {
            moveElevator();
        }
        catch (InterruptedException exception) {
            exception.fillInStackTrace();
        }
    }

    public void addJob(int targetFloor) {
        elevatorQueue.add(elevator, targetFloor);
    }

    private void moveElevator() throws InterruptedException {

        System.out.printf("Starting elevator %s%n", elevator.getElevatorId());

        if (elevator.getDirection().equals(Direction.UP)) {

            System.out.printf("Moving %s up!%n", elevator.getElevatorId());

            if (isElevatorGoingUp()) {

                int targetFloor = elevatorQueue.getMinHeap().poll();

                System.out.printf("Moving elevator %s to Floor %s%n", elevator.getElevatorId(), targetFloor);
                Thread.sleep(ELEVATOR_MOVING_DELAY);

                elevator.setCurrentFloorNumber(targetFloor);
                System.out.printf("Elevator %s reached Floor %s%n", elevator.getElevatorId(), targetFloor);

                if(elevatorQueue.getMinHeap().isEmpty()) {

                    addPendingJobsToElevatorQueue();

                    System.out.printf("Changing %s direction Down!%n", elevator.getElevatorId());
                    elevator.setDirection(Direction.DOWN);
                }
            }
        } else {

            System.out.printf("Moving %s down!%n", elevator.getElevatorId());

            if (isElevatorGoingDown()) {

                int targetFloor = elevatorQueue.getMaxHeap().poll();

                elevator.setCurrentFloorNumber(targetFloor);

                System.out.printf("Moving elevator %s to Floor %s%n", elevator.getElevatorId(), targetFloor);
                Thread.sleep(ELEVATOR_MOVING_DELAY);

                elevator.setCurrentFloorNumber(targetFloor);
                System.out.printf("Elevator %s reached Floor %s%n", elevator.getElevatorId(), targetFloor);

                if(elevatorQueue.getMaxHeap().isEmpty()) {

                    addPendingJobsToElevatorQueue();

                    System.out.printf("Changing %s direction UP!%n", elevator.getElevatorId());
                    elevator.setDirection(Direction.UP);
                }
            }
        }

        if(!isElevatorGoingDown() && !isElevatorGoingUp()) {

            addPendingJobsToElevatorQueue();
        }
    }

    private void addPendingJobsToElevatorQueue() {

        if(isElevatorHasPendingJobs()) {

            if (elevator.getDirection().equals(Direction.UP)) {

                for (int floorNumber : elevatorQueue.getPendingJobs()) {
                    elevatorQueue.getMinHeap().add(floorNumber);
                }

            } else {

                for (int floorNumber : elevatorQueue.getPendingJobs()) {
                    elevatorQueue.getMaxHeap().add(floorNumber);
                }
            }

            elevatorQueue.setPendingJobs(new ArrayList<>());
            move();
        }
    }

    private boolean isElevatorGoingUp() {
        return !elevatorQueue.getMinHeap().isEmpty();
    }

    private boolean isElevatorGoingDown() {
        return !elevatorQueue.getMaxHeap().isEmpty();
    }

    private boolean isElevatorHasPendingJobs() {
        return !elevatorQueue.getPendingJobs().isEmpty();
    }
}
