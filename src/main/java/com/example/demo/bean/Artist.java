package com.example.demo.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Artist {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String name;
	List<Album> albums = new ArrayList<Album>();
	List<Song> songs = new ArrayList<Song>();
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
	public Artist(Long id, String name, List<Album> albums, List<Song> songs) {
		super();
		this.id = id;
		this.name = name;
		this.albums = albums;
		this.songs = songs;
	}
	public Artist() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
