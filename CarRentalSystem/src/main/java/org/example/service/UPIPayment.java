package org.example.service;

import org.example.interfaces.Payment;
import org.example.model.Bill;

public class UPIPayment extends Payment {

    @Override
    public boolean makePayment(Bill bill) {
        return true;
    }
}
