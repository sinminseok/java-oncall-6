package oncall.domain;

import java.util.Arrays;

public enum LegalHoliday {
    NONE("없음", 0, 0),
    FIRST_DAY("신정", 1,1),
    INDEPENDENCE_MOVEMENT_DAY("삼일절", 3,1),
    CHILD_DAY("어린이날", 5,5),
    MEMORIAL_DAY("현충일", 6,6),
    LIBERATION_DAY("광복절", 8,15),
    NATIONAL_FOUNDATION_DAY("개천절", 10,3),
    KOREAN_LANGUAGE_DAY("한글날", 10,9),
    CHRISTMAS_DAY("성탄절", 12,25);

    private final String name;
    private final int month;
    private final int day;

    LegalHoliday(String name, int month, int day) {
        this.name = name;
        this.month = month;
        this.day = day;
    }

    public static LegalHoliday findByDate(int month, int day){
        return Arrays.stream(values())
                .filter(legalHoliday -> (legalHoliday.month == month) && (legalHoliday.day == day))
                .findFirst()
                .orElse(NONE);
    }
}
