package oncall.domain;

import oncall.global.validator.UserValidator;

import java.util.List;
import java.util.stream.Collectors;

public class UserGroup {
    private final List<User> users;

    private UserGroup(final List<User> users) {
        this.users = users;
    }

    public static UserGroup from(final List<String> names){
        UserValidator.validateUserGroup(names);
        List<User> collect = names.stream()
                .map(User::from)
                .collect(Collectors.toList());
        return new UserGroup(collect);
    }
}
