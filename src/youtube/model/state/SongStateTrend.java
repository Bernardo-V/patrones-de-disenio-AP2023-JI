package youtube.model.state;

import youtube.model.Icon;
import youtube.model.SongStateI;

public class SongStateTrend implements SongStateI {
    private final String icon = Icon.FIRE.text();

    @Override
    public void printLabel(String artist, String album, String title, Integer albumYear) {
        System.out.println(this.icon + " - " + title + " (" + album + " - " + albumYear + ")");
    }
}