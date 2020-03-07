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
	List<Song> songs = new ArrayList<Song>();
	@OneToMany
	List<PlayListSong> playListSongs = new ArrayList<PlayListSong>();
}
