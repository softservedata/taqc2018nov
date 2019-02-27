package com.softserve.edu.poclassic.data;

import java.util.ArrayList;
import java.util.List;

public class User {
    
    private String login;
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public static User getByList(List<String> row) {
        return new User(row.get(0), row.get(1));
    }
    
    public static List<User> getByLists(List<List<String>> rows) {
        List<User> result = new ArrayList<>();
        if (!rows.get(0).get(2).contains("@")) {
            rows.remove(0);
        }
        for (List<String> currentRow : rows) {
            result.add(getByList(currentRow));
        }
        return result;
    }

}
