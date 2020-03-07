package com.example.demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PlayListSong {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	@ManyToOne
	Song song;
	@ManyToOne
	PlayList playList;
}
