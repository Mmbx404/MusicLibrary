package com.example.demo.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class PlayList {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String libelle;
	@OneToMany
	List<Song> songs = new ArrayList<Song>();
	@OneToMany
	List<PlayListSong> playListSongs = new ArrayList<PlayListSong>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public List<Song> getSongs() {
		return songs;
	}
	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
	public List<PlayListSong> getPlayListSongs() {
		return playListSongs;
	}
	public void setPlayListSongs(List<PlayListSong> playListSongs) {
		this.playListSongs = playListSongs;
	}
	public PlayList(Long id, String libelle, List<Song> songs, List<PlayListSong> playListSongs) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.songs = songs;
		this.playListSongs = playListSongs;
	}
	public PlayList() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
