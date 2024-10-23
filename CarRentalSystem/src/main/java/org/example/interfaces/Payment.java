package org.example.interfaces;

public abstract class Payment {

    private float amount = 0;

    protected abstract boolean makePayment(int amount);
}
