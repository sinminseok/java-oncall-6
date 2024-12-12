package oncall.global.validator;

import oncall.global.exception.CustomException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static oncall.global.exception.ErrorMessage.ERROR_USER_NAME_DUPLICATE;
import static oncall.global.exception.ErrorMessage.ERROR_USER_NAME_RANGE;

public class UserValidator {
    private static final int MIN_USER_NAME_RANGE = 1;
    private static final int MAX_USER_NAME_RANGE = 5;
    private static final int MIN_USER_COUNT_RANGE = 5;

    public static void validateUserGroup(final List<String> names){
        validateDuplicateNames(names);
    }

    private static void validateDuplicateNames(final List<String> names){
        Set<String> set = new HashSet<>(names);
        if(set.size() != names.size()){
            throw new CustomException(ERROR_USER_NAME_DUPLICATE);
        }
    }

    public static void validateUser(final String name) {
        if (name.length() < MIN_USER_NAME_RANGE || name.length() > MAX_USER_NAME_RANGE) {
            throw new CustomException(ERROR_USER_NAME_RANGE);
        }
    }
}
