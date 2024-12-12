package oncall.domain;

import java.util.List;

public class WorkSchedule {
    private final List<UserSchedule> schedules;

    public WorkSchedule(List<UserSchedule> schedules) {
        this.schedules = schedules;
    }


}
