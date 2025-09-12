package org.example;

import org.example.observer.User;
import org.example.subject.Channel;
import org.example.subject.Subject;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ChannelService {
    private static final Set<String> channelsNames = new HashSet<>();

    // previous signature did not seems logical to me
    public Optional<Channel> createNewChannel(User user, String name) {
        if (channelsNames.contains(name)) {
            System.out.println("[INFO] Channel name \"" + name +  "\" is occupied");
            return Optional.empty();
        }
        channelsNames.add(name);
        return Optional.of(new Channel(user, name));
    }

    public void subscribeToChannel(Channel channel, Subject subject) {
        subject.subscribe(channel.getOwner());
    }

    public void newContentNotification(Channel channel, String message) {
        channel.notifyObservers(message);
    }
}
