package org.example.subject;

import org.example.observer.Observer;
import org.example.observer.User;

import java.util.HashSet;
import java.util.Set;
import java.time.*;

public class Channel implements Subject {
    // add attributes so that the user can create more than one channel
    private final String name;
    private final User owner;

    // Subscribers is set to insure that the user on subscribe once
    private final Set<Observer> subscribers = new HashSet<>();

    public Channel(User owner, String name) {
        this.name = name;
        this.owner = owner;
    }

    public void uploadVideo(String title) {
        LocalDate date = LocalDate.now();
        System.out.println("[UPLOAD] from " + owner.getUsername() + " to:");
        String message = name + " uploaded \"" + title + "\" (" + date + ")";
        notifyObservers(message);
    }

    @Override
    public void subscribe(Observer observer) {
        if (!subscribers.add(observer)) {
            System.out.println("[INFO] \"" + owner.getUsername() + "\" is already subscribed to " + name);
        }
    }

    @Override
    public void unsubscribe(Observer observer) {
        if (!subscribers.remove(observer)) {
            System.out.println("[INFO] \"" + owner.getUsername() + "\" is not subscribed to " + name +"\"");
        }
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer user : subscribers) {
            user.update(message);
        }
    }

    public String getName() {
        return name;
    }

    public User getOwner() {
        return owner;
    }
}
