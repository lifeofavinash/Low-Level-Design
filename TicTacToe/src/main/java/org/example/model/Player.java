package org.example.model;

public class Player {

    private String name;
    private PlayableIcon playableIcon;

    public Player(String playerName, PlayableIcon playableIcon) {

        this.name = playerName;
        this.playableIcon = playableIcon;

    }

    public String getName() {
        return this.name;
    }

    public PlayableIcon getPlayableIcon() {
        return this.playableIcon;
    }
}
