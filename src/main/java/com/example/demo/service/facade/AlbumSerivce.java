package com.example.demo.service.facade;


import java.util.Date;
import java.util.List;

import com.example.demo.bean.Album;


public interface AlbumSerivce {
	public List<Album> findAll();
	public Album findById(Long id);
	public int deleteAll();
	public int deleteById(Long id);
	public int update(String libelle,Album	album);
	public int save(Album album) ;
	public Album findByLibelle(String libelle);
	public List<Album> findByReleaseDate(Date releaseDate);
	public List<Album> findByArtistId(Long id);
	public List<Album> searchByLibelle(String libelle);
}
