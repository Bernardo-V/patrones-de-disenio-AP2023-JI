package youtube.model;

import youtube.model.state.SongStateNormal;
import youtube.model.state.SongStateTrend;
import youtube.model.state.SongStateBoom;

import java.time.Duration;
import java.time.LocalDateTime;

public class Song {

    private SongStateI songStateI;
    private String title;
    private String artist;
    private String album;
    private Integer albumYear;
    private Integer reproductions;
    private Integer likes;
    private Integer dislikes;
    private LocalDateTime lastPlayedTime;


    public Song(String title, String artist, String album, Integer albumYear) {
        this.songStateI = new SongStateNormal();
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.albumYear = albumYear;
        this.reproductions = 0;
        this.likes = 0;
        this.dislikes = 0;
        this.lastPlayedTime = null;
    }

    public Song(String title, String artist, String album, Integer albumYear, Integer reproductions, Integer likes, Integer dislikes, LocalDateTime lastPlayedTime) {
        this.songStateI = new SongStateNormal();
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.albumYear = albumYear;
        this.reproductions = reproductions;
        this.likes = likes;
        this.dislikes = dislikes;
        this.lastPlayedTime = lastPlayedTime;
    }

    public Boolean wasPlayedLastDay() {
        System.out.println("duracion" + Duration.between(this.lastPlayedTime, LocalDateTime.now()));
        return (this.lastPlayedTime != null) &&
                (Duration.between(this.lastPlayedTime, LocalDateTime.now()).toHours() <= 24);
    }


    public void printLabel() {
        if (this.reproductions > 1_000)
            this.songStateI = (this.dislikes >= 5_000) ? new SongStateNormal() : new SongStateBoom();

        if (this.reproductions > 50_000 && this.likes > 20_000)
            this.songStateI = this.wasPlayedLastDay() ? new SongStateTrend() : new SongStateNormal();

        this.songStateI.printLabel(this.artist, this.album, this.title, this.albumYear);
        this.lastPlayedTime = LocalDateTime.now();
    }

    public SongStateI getSongStateI() {
        return songStateI;
    }

    public void setSongStateI(SongStateI songStateI) {
        this.songStateI = songStateI;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getReproductions() {
        return reproductions;
    }

    public void setReproductions(Integer reproductions) {
        this.reproductions = reproductions;
    }

    public Integer getAlbumYear() {
        return albumYear;
    }

    public void setAlbumYear(Integer albumYear) {
        this.albumYear = albumYear;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getDislikes() {
        return dislikes;
    }

    public void setDislikes(Integer dislikes) {
        this.dislikes = dislikes;
    }

    public LocalDateTime getLastPlayedTime() {
        return lastPlayedTime;
    }

    public void setLastPlayedTime(LocalDateTime lastPlayedTime) {
        this.lastPlayedTime = lastPlayedTime;
    }
}
