package org.example.interfaces;

import org.example.model.Bill;

public abstract class Payment {

    public abstract boolean makePayment(Bill bill);
}
