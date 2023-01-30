package org.mzika.orm;

import jakarta.persistence.*;

@Entity
@Table(name = "songs")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String songName;
    @ManyToOne(cascade = CascadeType.ALL)
    private Artist artist;

    @Column(name = "url")
    private String url;

    @Column(name = "duration")
    private int duration;

    @Column(name = "streams")
    private int streams;
    private String genre;


    @ManyToOne
    @JoinColumn(name = "playlist_id")
    private  Playlist playlist;

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public Song(String songName, String url, int duration,String genre) {
        this.songName = songName;
        this.url = url;
        this.duration = duration;
        this.genre = genre;
    }

    public Song() {

    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
