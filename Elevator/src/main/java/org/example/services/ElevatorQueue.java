package org.example.services;

import lombok.Data;
import org.example.enums.Direction;
import org.example.interfaces.ElevatorQueueSubscriber;
import org.example.model.Elevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

@Data
public class ElevatorQueue {

    private List<ElevatorQueueSubscriber> subscribers;

    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    private List<Integer> pendingJobs;

    public ElevatorQueue() {

        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        this.pendingJobs = new ArrayList<>();
        this.subscribers = new ArrayList<>();

    }

    public void subscribe(ElevatorController elevatorController) {
        subscribers.add(elevatorController);
    }

    public void notifySubscribers() {

        for(ElevatorQueueSubscriber elevatorController: subscribers) {

            elevatorController.move();

        }

    }

    public void add(Elevator elevator, int targetFloor) {

         if(elevator.getDirection().equals(Direction.UP)) {

             if(targetFloor < elevator.getCurrentFloorNumber()) {
                 this.pendingJobs.add(targetFloor);
             }
             else if(targetFloor > elevator.getCurrentFloorNumber()) {
                 this.minHeap.add(targetFloor);
             }

         }
         else {
             if(targetFloor > elevator.getCurrentFloorNumber()) {
                 this.pendingJobs.add(targetFloor);
             }
             else if(targetFloor < elevator.getCurrentFloorNumber()) {
                 this.maxHeap.add(targetFloor);
             }
         }

        notifySubscribers();
    }
}
