package com.example.demo.service.Impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.bean.Album;
import com.example.demo.bean.Song;
import com.example.demo.dao.AlbumDao;
import com.example.demo.exception.TransactionFailedException;
import com.example.demo.service.facade.AlbumSerivce;
import com.example.demo.service.facade.ArtistService;
import com.example.demo.service.facade.SongService;

@Service
public class AlbumServiceImpl implements AlbumSerivce {
	@Autowired
	AlbumDao albumDao;
	@Autowired
	ArtistService artistService;
	@Autowired
	SongService songService;

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
	@Transactional
	public int update(Long id, Album album) {
		if (album.getArtist() == null || album.getLibelle() == null || album.getReleaseDate() == null)
			return -2;
		if (findById(id) == null || artistService.findById(album.getArtist().getId()) == null || findByLibelle(album.getLibelle()) != null)
			return -1;
		if (album.getSongs().size() > 0) {
			
			for (Song song : album.getSongs()) {		
				if(song.getId() != null)  songService.update(song.getId(),song);
				else songService.save(song);
			}
			}
		albumDao.save(album);
		return 1;

	}

	@Override
	@Transactional
	public int save(Album album)  {
		if (album.getArtist() == null || album.getLibelle() == null || album.getReleaseDate() == null)
			return -2;
		if (findByLibelle(album.getLibelle()) != null || artistService.findById(album.getArtist().getId()) == null)
			return -1;
		if (album.getSongs().size() > 0) {
			int success = 0;
			for (Song song : album.getSongs()) {
				success = songService.save(song);
				if (success != 1)
					throw new TransactionFailedException(
							"Song at" + album.getSongs().indexOf(song) + "not saved with error code" + success);
			}
		}
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

	@Override
	public List<Album> searchByLibelle(String libelle) {
		
		return albumDao.searchByLibelle(libelle);
	}

}
