package youtube.model.state;

import youtube.model.Icon;
import youtube.model.SongStateI;

public class SongStateBoom implements SongStateI {
    private final String icon = Icon.ROCKET.text();

    @Override
    public void printLabel(String artist, String album, String title, Integer albumYear) {
        System.out.println(this.icon + " - " + artist + "-" + title + " (" + album + " - " + albumYear + ")");
    }
}