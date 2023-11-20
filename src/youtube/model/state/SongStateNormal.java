package youtube.model.state;

import youtube.model.Icon;
import youtube.model.SongStateI;
public class SongStateNormal implements SongStateI {
    private final String icon = Icon.MUSICAL_NOTE.text();

    @Override
    public void printLabel(String artist, String album, String title, Integer albumYear) {
        System.out.println(this.icon + " - " + artist + " - " + album + " - " + title);
    }
}