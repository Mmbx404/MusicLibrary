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
}
