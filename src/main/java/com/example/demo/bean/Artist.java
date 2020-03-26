package com.example.demo.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Artist {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String name;
	@OneToMany(mappedBy = "artist")
	@JsonBackReference
	List<Album> albums = new ArrayList<Album>();
	@OneToMany(mappedBy = "artist")
	@JsonBackReference
	List<Song> songs = new ArrayList<Song>();
	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(name="ARTST_PIC")
	Byte[] Portrait;
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
	public Byte[] getPortrait() {
		return Portrait;
	}
	public void setPortrait(Byte[] portrait) {
		Portrait = portrait;
	}
	public Artist(Long id, String name, List<Album> albums, List<Song> songs, Byte[] portrait) {
		super();
		this.id = id;
		this.name = name;
		this.albums = albums;
		this.songs = songs;
		Portrait = portrait;
	}
	public Artist() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
