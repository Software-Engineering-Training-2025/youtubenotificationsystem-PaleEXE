package org.example.observer;

public interface Observer {
    void update(String message);

    @Override
    boolean equals(Object o);

    @Override
    int hashCode();
}
