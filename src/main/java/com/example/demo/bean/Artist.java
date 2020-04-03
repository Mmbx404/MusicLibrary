package com.example.demo.bean;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Artist {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String name;
	@OneToMany(mappedBy = "artist")
	@JsonProperty(access=Access.WRITE_ONLY)
	@NotFound(action = NotFoundAction.IGNORE)
	List<Album> albums = new ArrayList<Album>();
	@OneToMany(mappedBy = "artist")
	@JsonProperty(access=Access.WRITE_ONLY)
	@NotFound(action = NotFoundAction.IGNORE)
	List<Song> songs = new ArrayList<Song>();
	String portrait;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Album> getAlbums() {
		return albums;
	}
	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}
	public List<Song> getSongs() {
		return songs;
	}
	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
	
	public String getPortrait() {
		return portrait;
	}
	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}
	
	public Artist( String name, List<Album> albums, List<Song> songs, String portrait) {
		super();
		this.id = id;
		this.name = name;
		this.albums = albums;
		this.songs = songs;
		this.portrait = portrait;
	}
	public Artist() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
