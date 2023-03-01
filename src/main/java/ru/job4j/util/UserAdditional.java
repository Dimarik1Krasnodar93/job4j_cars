package ru.job4j.util;

import ru.job4j.toOne.User;

import javax.servlet.http.HttpSession;

public class UserAdditional {

    private UserAdditional() {

    }

    public static User getFromHttpSession(HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("user");
        if (user == null) {
            user = new User("", "");
            user.setLogin("Гость");
        }
        return user;
    }

}
