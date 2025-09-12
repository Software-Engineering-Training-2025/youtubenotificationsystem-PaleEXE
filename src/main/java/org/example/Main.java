package org.example;

import org.example.observer.User;
import org.example.subject.Channel;

public class Main {
    public static void main(String[] args) {
        ChannelService channelService = new ChannelService();

        User pale = new User("Mohammad");
        User fadi = new User("Fadi");
        User mimi = new User("Mimi");
        User silk = new User("Hornet");

        // I did not check for empty optional because it is a test code
        // of course I would add proper handling in the real API
        Channel paleChannel = channelService.createNewChannel(pale, "Pale").get();
        Channel mimiChannel = channelService.createNewChannel(mimi, "MIMI").get();
        Channel fadiChannel = channelService.createNewChannel(fadi, "EXE_").get();
        Channel silkChannel = channelService.createNewChannel(silk, "SHAW").get();

        channelService.subscribeToChannel(paleChannel, mimiChannel);
        channelService.subscribeToChannel(fadiChannel, mimiChannel);
        channelService.subscribeToChannel(silkChannel, mimiChannel);

        channelService.subscribeToChannel(mimiChannel, silkChannel);
        channelService.subscribeToChannel(paleChannel, silkChannel);

        channelService.subscribeToChannel(fadiChannel, paleChannel);
        channelService.subscribeToChannel(mimiChannel, paleChannel);

        mimiChannel.uploadVideo("Hollow Knight PeakSong iz ez");
        silkChannel.uploadVideo("GIT GUD");
        fadiChannel.uploadVideo("IDK");

        // test duplicate channel names
        Channel _noMimiChannel = channelService.createNewChannel(mimi, "MIMI").orElse(null);

        // test subscribe twice
        channelService.subscribeToChannel(silkChannel, mimiChannel);

        // test unsubscribe
        mimiChannel.unsubscribe(pale);
        mimiChannel.uploadVideo("SilkSong is the best game ever made");
    }
}