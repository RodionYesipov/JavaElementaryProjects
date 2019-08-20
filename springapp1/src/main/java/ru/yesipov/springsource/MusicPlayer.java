package ru.yesipov.springsource;

import java.util.List;

public class MusicPlayer {
    private Music music;
    private String name;
    private int volume;

    public void playMusic() {

            System.out.println("Playing " + music.getSong());

    }

    public void setMusic(Music music) {
        this.music = music;
    }

    public Music getMusic() {
        return music;
    }

    public MusicPlayer() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }
}
