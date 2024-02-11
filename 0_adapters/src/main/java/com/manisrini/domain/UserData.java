package com.manisrini.domain;

import java.util.List;

public interface UserData {

    default List<User> buildUser() {
        return List.of(new User("mani", 40, true), new User("kumar", 38, true),
                new User("ravi", 21, true), new User("jack", 25, false),
                new User("matt", 40, false), new User("mike", 38, false),
                new User("Nick", 18, false), new User("David", 58, true),
                new User("Andy", 60, true), new User("Eric", 25, false));
    }
}
