package oncall.domain;

import oncall.global.validator.UserValidator;

import java.util.List;
import java.util.stream.Collectors;

public class UserGroup {
    private final List<User> users;
    private int index;

    private UserGroup(final List<User> users) {
        this.users = users;
        this.index = 0;
    }

    public static UserGroup from(final List<String> names){
        UserValidator.validateUserGroup(names);
        List<User> collect = names.stream()
                .map(User::from)
                .collect(Collectors.toList());
        return new UserGroup(collect);
    }

    public User getCurrentUser(){
        User responseUser = users.get(index);
        index ++;
        if(index >= users.size()){
            index = 0;
        }
        return responseUser;
    }
}
