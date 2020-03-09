package com.example.demo.bean;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Song {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String libelle;
	Date releaseDate;
	@ManyToOne
	Album album;
	@ManyToOne
	Artist artist;
	@OneToMany
	List<PlayListSong> playListSongs = new ArrayList<PlayListSong>();
	@ManyToOne
	Genre genre;
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
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}
	public Artist getArtist() {
		return artist;
	}
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	public List<PlayListSong> getPlayListSongs() {
		return playListSongs;
	}
	public void setPlayListSongs(List<PlayListSong> playListSongs) {
		this.playListSongs = playListSongs;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public Song(Long id, String libelle, Date releaseDate, Album album, Artist artist, List<PlayListSong> playListSongs,
			Genre genre) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.releaseDate = releaseDate;
		this.album = album;
		this.artist = artist;
		this.playListSongs = playListSongs;
		this.genre = genre;
	}
	public Song() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
