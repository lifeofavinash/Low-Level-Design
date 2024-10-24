package org.example.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.example.enums.RegistrationStatus;
import org.example.model.Bill;
import org.example.model.User;
import org.example.model.Vehicle;
import org.example.util.BillGenerator;

import java.util.Date;

@Data
public class Registration {
    private String registrationId;
    private User user;
    private Vehicle vehicle;
    private RegistrationStatus registrationStatus;
    private Date startDate;
    private Date endDate;
    private BillGenerator billGenerator;

    public Registration() {
        this.billGenerator = new BillGenerator(new UPIPayment());
    }

    public Registration(String registrationId, User user, Vehicle vehicle, RegistrationStatus registrationStatus, Date startDate, Date endDate){

        this();

        this.registrationId = registrationId;
        this.user = user;
        this.vehicle = vehicle;
        this.registrationStatus = registrationStatus;
        this.startDate = startDate;
        this.endDate = endDate;

    }

    public void register() {

        Bill bill = billGenerator.generateBill(user, vehicle, startDate, endDate);

        System.out.println("Bill Generated: " + bill.toString());

        boolean isPaymentSuccessful = billGenerator.makePayment(bill);

        if (isPaymentSuccessful) {

            this.registrationStatus = RegistrationStatus.REGISTERED;
            System.out.println("Registration Successful!");

        } else {

            this.registrationStatus = RegistrationStatus.FAILED;
            System.out.println("Registration Failed!");

        }
    }

}
