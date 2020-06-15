package edu.intensive;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Payment {
    @Id
    @GeneratedValue
    Long paymentId;
    Long studentId;
    Long courseId;
    String status;

    @PostPersist
    public void onPostPersist() {
        PaymentRequested paymentRequested = new PaymentRequested();
        BeanUtils.copyProperties(this, paymentRequested);
        paymentRequested.publishAfterCommit();
    }

    @PreUpdate
    public void onPreUpdate() {
        if(this.getStatus().equals("Payment Approved")) {
            PaymentApproved paymentApproved = new PaymentApproved();
            BeanUtils.copyProperties(this, paymentApproved);
            this.setStatus("Payment Approved? Paid !");
            paymentApproved.publishAfterCommit();
        } else {
            System.out.println("Payment : There are no Requested Payment. Check your format! ");
        }
    }
}
