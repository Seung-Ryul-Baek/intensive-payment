package edu.intensive;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PaymentCanceled extends AbstractEvent{
    Long paymentId;
    Long courseId;
    Long studentId;
    String status;

    public PaymentCanceled() {
        super();
    }
}
