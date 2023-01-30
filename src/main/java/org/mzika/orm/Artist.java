package org.mzika.orm;

import java.util.Set;

import jakarta.persistence.*;
@Entity
@Table(name = "artists")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @Column(name = "artistName")
    private String ArtistName;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Song> songs;

    public Artist(String artistName) {
        ArtistName = artistName;
    }

    public Artist() {

    }

    public String getArtistName() {
        return ArtistName;
    }

    public void setArtistName(String artistName) {
        ArtistName = artistName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Song> getSongs() {
        return songs;
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }

}
