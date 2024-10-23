package org.example.service;

import org.example.interfaces.Payment;

public class UPIPayment extends Payment {

    @Override
    protected boolean makePayment(int amount) {
        return true;
    }
}
