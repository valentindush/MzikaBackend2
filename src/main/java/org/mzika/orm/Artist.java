package org.mzika.orm;

import java.util.Set;

import javax.persistence.*;
@Entity
@Table(name = "artist")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;
    private String ArtistName;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Song> songs;

    public Artist(String artistName) {
        super();
        ArtistName = artistName;
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
