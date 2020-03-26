package com.example.demo.service.Impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Song;
import com.example.demo.dao.SongDao;
import com.example.demo.service.facade.AlbumSerivce;
import com.example.demo.service.facade.ArtistService;
import com.example.demo.service.facade.GenreService;
import com.example.demo.service.facade.SongService;
@Service
public class SongServiceImpl implements SongService{
	@Autowired
	SongDao songDao;
	@Autowired
	AlbumSerivce albumService;
	@Autowired
	ArtistService artistService;
	@Autowired
	GenreService genreService;
	@Override
	public List<Song> findAll() {
		return songDao.findAll();
	}

	@Override
	public Song findById(Long id) {
		if (songDao.findById(id).isPresent()) return songDao.findById(id).get();
		else return null;
	}

	@Override
	public int deleteAll() {
		songDao.deleteAll();
		if (findAll() == null) return 1;
		else return -1;
	}

	@Override
	public int deleteById(Long id) {
		songDao.deleteById(id);
		if (findById(id) == null) return 1;
		else return -1;
	}

	@Override
	public int update(Long id, Song song) {
		if ( findById(id) != null &&
			 artistService.findById(song.getArtist().getId()) != null &&
			 albumService.findById(song.getAlbum().getId()) != null &&
			 genreService.findById(song.getGenre().getId()) != null
			 ) {
			songDao.save(song);
			return 1;
		} else return -1;

	}

	@Override
	public int save(Song song) {
		if ( findById(song.getId()) == null &&
				 artistService.findById(song.getArtist().getId()) != null &&
				 albumService.findById(song.getAlbum().getId()) != null &&
				 genreService.findById(song.getGenre().getId()) != null
				 ) {
				songDao.save(song);
				return 1;
			} else return -1;
	}

	@Override
	public Song findByLibelle(String libelle) {
		return songDao.findByLibelle(libelle);
	}

	@Override
	public List<Song> findByReleaseDate(Date releaseDate) {
		return songDao.findByReleaseDate(releaseDate);
	}

	@Override
	public List<Song> findByAlbumId(Long id) {
		return songDao.findByAlbumId(id);
	}

	@Override
	public List<Song> findByArtistId(Long id) {
		return songDao.findByArtistId(id);
	}



	@Override
	public List<Song> findByGenreId(Long id) {
		return songDao.findByGenreId(id);
	}

}
