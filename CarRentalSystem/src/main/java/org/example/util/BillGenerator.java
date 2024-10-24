package org.example.util;

import lombok.Data;
import org.example.interfaces.Payment;
import org.example.model.Bill;
import org.example.model.User;
import org.example.model.Vehicle;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class BillGenerator {
    private Payment payment;

    public BillGenerator(Payment payment) {
        this.payment = payment;
    }

    public Bill generateBill(User user, Vehicle vehicle, Date startDate, Date endDate) {

        long duration = endDate.getTime() - startDate.getTime();

        long billAmount = calculateFair(vehicle, duration);

        return new Bill(user, billAmount);

    }

    public boolean makePayment(Bill bill) {
        return payment.makePayment(bill);
    }

    private long calculateFair(Vehicle vehicle, long duration) {

        return vehicle.getVehicleRate() * duration;
    }

}
