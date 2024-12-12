package oncall.domain;

public class OncallManager {
    private final UserGroup weekUsers;
    private final UserGroup holidayUsers;
    private final int month;
    private DayOfWeek dayOfWeek;
    private int day;

    public OncallManager(UserGroup weekUsers, UserGroup holidayUsers, int month, DayOfWeek dayOfWeek, int day) {
        this.weekUsers = weekUsers;
        this.holidayUsers = holidayUsers;
        this.month = month;
        this.dayOfWeek = dayOfWeek;
        this.day = day;
    }

    public UserSchedule assignUser() {
        if (isHolyDay()) {
            return new UserSchedule(holidayUsers.getCurrentUser(), month, dayOfWeek, day);
        }
        return new UserSchedule(weekUsers.getCurrentUser(), month, dayOfWeek, day);
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

    public void setNextDay() {
        this.dayOfWeek = dayOfWeek.nextDayOfWeek();
        this.day += 1;
    }

    public boolean isHolyDay() {
        if (dayOfWeek.isHoliday() || LegalHoliday.findByDate(month, day) != LegalHoliday.NONE) {
            return true;
        }
        return false;
    }

}
