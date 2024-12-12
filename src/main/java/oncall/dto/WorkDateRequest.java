package oncall.dto;

import oncall.domain.DayOfWeek;

public record WorkDateRequest(int month, DayOfWeek dayOfWeek) {
}
