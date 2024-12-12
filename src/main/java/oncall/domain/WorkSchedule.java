package oncall.domain;

import java.util.ArrayList;
import java.util.List;

public class WorkSchedule {
    private final List<UserSchedule> schedules;

    public WorkSchedule() {
        this.schedules = new ArrayList<>();
    }

    public void addUserSchedule(final UserSchedule userSchedule) {
        schedules.add(userSchedule);
    }

    public boolean isSequenceUser(UserSchedule userSchedule) {
        if (schedules.size() == 0) {
            return false;
        }
        UserSchedule lastSchedule = schedules.get(schedules.size() - 1);
        return userSchedule.getUserName().equals(lastSchedule.getUserName());
    }

    public List<UserSchedule> getSchedules() {
        return schedules;
    }
}
