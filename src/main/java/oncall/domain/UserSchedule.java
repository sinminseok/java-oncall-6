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

    public boolean isHolyDay() {
        if (dayOfWeek.isHoliday() || LegalHoliday.findByDate(month, day) != LegalHoliday.NONE) {
            return true;
        }
        return false;
    }

    public User getUser() {
        return user;
    }

    public String getUserName() {
        return user.getName();
    }

    public int getMonth() {
        return month;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public int getDay() {
        return day;
    }
}
