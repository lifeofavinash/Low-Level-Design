package org.lld.service;

import org.lld.enums.OperationType;
import org.lld.model.ATM;
import org.lld.model.Card;

public abstract class ATMState {

    public  void insertCard(ATM atm, Card card){
        System.out.println("This operation is not allowed");
    }
    
    public  boolean authenticateCard(ATM atm, Card card, int pin){
        System.out.println("This operation is not allowed");
        return false;
    }
    
    public  void setOperation(ATM atm, OperationType operationType){
        System.out.println("This operation is not allowed");
    }
    
    public  void performOperation(ATM atm, Card card){
        System.out.println("This operation is not allowed");
    }
    
    public  void exit(ATM atm){
        System.out.println("This operation is not allowed");
    }

    public void withdrawCash(ATM atm, Card card, long amount){
        System.out.println("This operation is not allowed");
    }

}
