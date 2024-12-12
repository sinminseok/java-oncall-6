package oncall.domain;

import oncall.global.exception.CustomException;
import oncall.global.exception.ErrorMessage;

import java.util.Arrays;

import static oncall.global.exception.ErrorMessage.ERROR_DAY_OF_WEEK;

public enum DayOfWeek {
    MONDAY("월"),
    TUESDAY("화"),
    WEDNESDAY("수"),
    THURSDAY("목"),
    FRIDAY("금"),
    SATURDAY("토"),
    SUNDAY("일");

    private final String name;

    DayOfWeek(String name) {
        this.name = name;
    }

    public DayOfWeek nextDayOfWeek() {
        int currentOrdinal = this.ordinal();
        DayOfWeek[] days = DayOfWeek.values();
        int nextOrdinal = (currentOrdinal + 1) % days.length;
        return days[nextOrdinal];
    }

    public static DayOfWeek valueOfCommand(String name){
        return Arrays.stream(values())
                .filter(d -> d.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new CustomException(ERROR_DAY_OF_WEEK));
    }

    public boolean isHoliday(){
        return this.equals(SATURDAY) || this.equals(SUNDAY);
    }
}
