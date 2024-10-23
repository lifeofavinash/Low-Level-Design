package org.example.service;

import lombok.Data;
import org.example.enums.RegistrationStatus;
import org.example.model.User;
import org.example.model.Vehicle;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Registration {
    private int registrationId;
    private User user;
    private Vehicle vehicle;
    private RegistrationStatus registrationStatus;
    private Date startDate;
    private Date endDate;
    private LocalDateTime startTimestamp;
    private LocalDateTime endTimeStamp;
    private BillGenerator billGenerator;

}
