package org.example.observer;

import java.util.Objects;

public class User implements Observer {
    private static int count = 0;
    private final int id;
    private final String username;

    public User(String username) {
        this.username = username;
        id = count++;
    }

    @Override
    public void update(String message) {
        System.out.println("\t[USER]    " + username);
        System.out.println("\t[MESSAGE] " + message);
    }

    public int getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }

    // The following methods are required to make objects of this class hashable
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User other)) return false;
        return id == other.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
