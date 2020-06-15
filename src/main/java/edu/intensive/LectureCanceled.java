package edu.intensive;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LectureCanceled extends AbstractEvent {
    Long lectureId;
    Long studentId;
    Long courseId;
    String status;
    public LectureCanceled() {
        super();
    }
}
