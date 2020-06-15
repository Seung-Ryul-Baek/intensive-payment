package edu.intensive;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter @Setter
public class PaymentRequested extends AbstractEvent{
    Long paymentId;
    Long courseId;
    Long studentId;
    String status;

    public PaymentRequested() {
        super();
    }
}
