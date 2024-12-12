package oncall.global.exception;

public enum ErrorMessage {
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
