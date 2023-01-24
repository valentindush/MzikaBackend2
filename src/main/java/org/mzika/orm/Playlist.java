package org.mzika.orm;

import java.util.Set;

import javax.persistence.*;

@Table(name = "playlist")

public class Playlist {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int id;
	private String name;

	@ManyToOne(cascade = CascadeType.ALL)

	private Set<Song> songs;

	public Playlist(String name) {
		super();
		this.name = name;
	}

	private User user;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Song> getSongs() {
		return songs;
	}

	public void setSongs(Set<Song> songs) {
		this.songs = songs;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
