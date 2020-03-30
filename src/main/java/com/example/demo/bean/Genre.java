package com.example.demo.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
@Entity
public class Genre {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String libelle;
	@OneToMany(mappedBy = "genre")
	@JsonProperty(access=Access.WRITE_ONLY)
	List<Song> songs = new ArrayList<Song>();
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
	public Genre(Long id, String libelle, List<Song> songs) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.songs = songs;
	}
	public Genre() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
