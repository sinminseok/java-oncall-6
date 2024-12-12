package oncall.domain;

import oncall.global.validator.UserValidator;

import java.util.Collections;
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
        return users.get(index);
    }

    public void increaseIndex(){
        index ++;
        if(index >= users.size()){
            index = 0;
        }
    }

    public void swapOrder(User currentUser){
        int currentUserIndex = users.indexOf(currentUser);
        int nextUserIndex = currentUserIndex + 1;
        if(currentUserIndex == users.size() - 1) {
            nextUserIndex = 0;
        }
        Collections.swap(users, nextUserIndex, currentUserIndex);
    }

}
