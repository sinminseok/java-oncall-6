package oncall.domain;

import oncall.global.validator.UserValidator;

public class User {
    private final String name;

    private User(final String name) {
        this.name = name;
    }

    public static User from(final String name){
        UserValidator.validateUser(name);
        return new User(name);
    }

    public String getName() {
        return name;
    }
}
