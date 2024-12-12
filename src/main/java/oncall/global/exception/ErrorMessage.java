package oncall.global.exception;

public enum ErrorMessage {
    ERROR_INVALID_INPUT("유효하지 않은 입력 값입니다. 다시 입력해 주세요."),
    ERROR_DAY_OF_WEEK("존재하지 않는 요일 입니다."),
    ERROR_USER_COUNT_RANGE("근무자는 최소 5명 이상, 최대 35명 까지 허용합니다."),
    ERROR_USER_NAME_DUPLICATE("중복되는 근무자 닉네임은 허용하지 않습니다."),
    ERROR_USER_NAME_RANGE("근무자 닉네임은 1~5자리 까지 허용합니다.");

    private static final String PREFIX = "[ERROR] ";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
