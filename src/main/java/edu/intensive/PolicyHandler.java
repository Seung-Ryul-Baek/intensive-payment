package edu.intensive;

import edu.intensive.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler {
    @Autowired
    PaymentRepository paymentRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void onEvent(@Payload String message) {
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverLectureCanceled(@Payload LectureCanceled lectureCanceled) {
        if (lectureCanceled.isMe()) {
            Payment payment = null;
            try {
                payment = paymentRepository.findByStudentIdAndCourseId
                        (lectureCanceled.getStudentId(), lectureCanceled.getCourseId());
                payment.setStatus("Canceled");
                paymentRepository.save(payment);
                System.out.println("Student : " + lectureCanceled.getStudentId() + ", Course : " + lectureCanceled.getCourseId());
            } catch (Exception e) {
                System.out.println("Payment : Can not Found");
            }
        }
    }
}
