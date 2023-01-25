package org.mzika.orm;

import javax.persistence.*;

@Entity
@Table(name = "song")
public class Song {

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String songName;
    @ManyToOne(cascade = CascadeType.ALL)
    private Artist artist;
    private String url;
    private int duration;
    private int streams;
    private String genre;

    public Song(String songName, String url, int duration) {
        super();
        this.songName = songName;
        this.url = url;
        this.duration = duration;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getStreams() {
        return streams;
    }

    public void setStreams(int streams) {
        this.streams = streams;
    }
}
