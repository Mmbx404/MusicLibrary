package com.example.demo.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class PlayList {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String libelle;
	@ManyToMany
	@JoinTable(name = "PlayList_Song", joinColumns = @JoinColumn(name = "PlayList_id"), inverseJoinColumns = @JoinColumn(name = "Song_id"))
	@JsonProperty(access = Access.WRITE_ONLY)
	List<Song> playListSongs = new ArrayList<Song>();

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

	public List<Song> getPlayListSongs() {
		return playListSongs;
	}

	public void setPlayListSongs(List<Song> playListSongs) {
		this.playListSongs = playListSongs;
	}

	public PlayList(Long id, String libelle, List<Song> playListSongs) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.playListSongs = playListSongs;
	}

	public PlayList() {
		super();
		// TODO Auto-generated constructor stub
	}

}
