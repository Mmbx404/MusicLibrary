package com.example.demo.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Album {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String libelle;
	Date releaseDate;
	List<Song> songs = new ArrayList<Song>();
	@ManyToOne
	Artist artist;
}
