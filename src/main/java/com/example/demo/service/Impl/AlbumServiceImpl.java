package com.example.demo.service.Impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Album;
import com.example.demo.dao.AlbumDao;
import com.example.demo.dao.ArtistDao;
import com.example.demo.service.facade.AlbumSerivce;

@Service
public class AlbumServiceImpl implements AlbumSerivce {
	@Autowired
	AlbumDao albumDao;
	@Autowired
	ArtistDao artistDao;

	@Override
	public List<Album> findAll() {
		return albumDao.findAll();
	}

	@Override
	public Album findById(Long id) {
		if (albumDao.findById(id).isPresent())
			return albumDao.findById(id).get();
		else
			return null;
	}

	@Override
	public int deleteAll() {
		albumDao.deleteAll();
		if (findAll() == null)
			return 1;
		else
			return -1;
	}

	@Override
	public int deleteById(Long id) {
		albumDao.deleteById(id);
		if (findById(id) == null)
			return 1;
		else
			return -1;
	}

	@Override
	public int update(Long id, Album album) {
		if (findById(id) != null && artistDao.findById(album.getArtist().getId()) != null) {
			albumDao.save(album);
			return 1;
		} else
			return -1;
	}

	@Override
	public int save(Album album) {
		if (album.getArtist() == null || album.getLibelle() == null || album.getReleaseDate() == null)
			return -2;
		if (findByLibelle(album.getLibelle()) != null || artistDao.findById(album.getArtist().getId()) == null)
			return -1;

		albumDao.save(album);
		return 1;
	}

	@Override
	public Album findByLibelle(String libelle) {
		return albumDao.findByLibelle(libelle);
	}

	@Override
	public List<Album> findByReleaseDate(Date releaseDate) {
		return albumDao.findByReleaseDate(releaseDate);
	}

	@Override
	public List<Album> findByArtistId(Long id) {
		return albumDao.findByArtistId(id);
	}

}
