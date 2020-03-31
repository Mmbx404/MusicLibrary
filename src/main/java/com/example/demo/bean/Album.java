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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Album {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String libelle;
	@Temporal(TemporalType.DATE)
	Date releaseDate;
	@OneToMany(mappedBy = "album")
	@JsonProperty(access=Access.WRITE_ONLY)
	List<Song> songs = new ArrayList<Song>();
	@ManyToOne
	Artist artist;
	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(name="ALB_PIC")
	@JsonProperty(access=Access.WRITE_ONLY)
	Byte[] picture;
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
	public List<Song> getSongs() {
		return songs;
	}
	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
	public Artist getArtist() {
		return artist;
	}
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	public Album(Long id, String libelle, Date releaseDate, List<Song> songs, Artist artist) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.releaseDate = releaseDate;
		this.songs = songs;
		this.artist = artist;
	}
	public Album() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
