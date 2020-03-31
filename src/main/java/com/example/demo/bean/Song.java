package com.example.demo.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Song {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String libelle;
	@Temporal(TemporalType.DATE)
	Date releaseDate;
	@ManyToOne
	Album album;
	@ManyToOne
	Artist artist;
	@ManyToMany(mappedBy = "playListSongs")
	@JsonProperty(access=Access.WRITE_ONLY)
	List<PlayList> featuringPlayLists = new ArrayList<PlayList>();
	@ManyToOne
	Genre genre;
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "SONG_MP3", columnDefinition = "BLOB")
	@JsonProperty(access=Access.WRITE_ONLY)
	Byte[] songFile;
    String[] lyrics;
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
	public List<PlayList> getFeaturingPlayLists() {
		return featuringPlayLists;
	}
	public void setFeaturingPlayLists(List<PlayList> featuringPlayLists) {
		this.featuringPlayLists = featuringPlayLists;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public Byte[] getSongFile() {
		return songFile;
	}
	public void setSongFile(Byte[] songFile) {
		this.songFile = songFile;
	}
	public String[] getLyrics() {
		return lyrics;
	}
	public void setLyrics(String[] lyrics) {
		this.lyrics = lyrics;
	}
	public Song(Long id, String libelle, Date releaseDate, Album album, Artist artist,
			List<PlayList> featuringPlayLists, Genre genre, Byte[] songFile, String[] lyrics) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.releaseDate = releaseDate;
		this.album = album;
		this.artist = artist;
		this.featuringPlayLists = featuringPlayLists;
		this.genre = genre;
		this.songFile = songFile;
		this.lyrics = lyrics;
	}
	public Song() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
