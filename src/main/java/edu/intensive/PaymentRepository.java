package edu.intensive;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface PaymentRepository extends PagingAndSortingRepository<Payment, Long> {
    Payment findByStudentIdAndCourseId(Long studentId, Long courseId);
}
