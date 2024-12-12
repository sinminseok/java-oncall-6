package oncall.domain;

import java.time.LocalDate;

public class UserSchedule {
    private final User user;
    private final int month;
    private final DayOfWeek dayOfWeek;
    private final int day;

    public UserSchedule(final User user, final int month, final DayOfWeek dayOfWeek, final int day) {
        this.user = user;
        this.month = month;
        this.dayOfWeek = dayOfWeek;
        this.day = day;
    }
}
