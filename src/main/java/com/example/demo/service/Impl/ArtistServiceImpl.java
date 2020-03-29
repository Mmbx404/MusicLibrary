package com.example.demo.service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Album;
import com.example.demo.bean.Artist;
import com.example.demo.bean.Song;
import com.example.demo.dao.ArtistDao;
import com.example.demo.service.facade.AlbumSerivce;
import com.example.demo.service.facade.ArtistService;
import com.example.demo.service.facade.SongService;

@Service
public class ArtistServiceImpl implements ArtistService {
	@Autowired
	ArtistDao artistDao;
	@Autowired
	AlbumSerivce albumService;
	@Autowired
	SongService songService;

	@Override
	public List<Artist> findAll() {
		return artistDao.findAll();
	}

	@Override
	public Artist findById(Long id) {
		if (artistDao.findById(id).isPresent())
			return artistDao.findById(id).get();
		else
			return null;
	}

	@Override
	public int deleteAll() {
		artistDao.deleteAll();
		if (findAll() == null)
			return 1;
		else
			return -1;
	}

	@Override
	public int deleteById(Long id) {
		artistDao.deleteById(id);
		if (findById(id) == null)
			return 1;
		else
			return -1;
	}

	@Override
	@Transactional
	public int update(Long id, Artist artist) {
		if (findById(id) == null)
			return -1;
		if (artist.getName() == null || artist.getName() == "")
			return -2;
		if (artist.getAlbums().size() > 0) {
			for (Album album : artist.getAlbums()) {
				if (album.getArtist() != artist)
					album.setArtist(artist);
				if (albumService.findByLibelle(album.getLibelle()) != null)
					albumService.update(album.getId(), album);
				else
					albumService.save(album);
			}
		}
		if (artist.getSongs().size() > 0) {
			for (Song song : artist.getSongs()) {
				if (song.getArtist() != artist)
					song.setArtist(artist);
				if (songService.findByLibelle(song.getLibelle()) != null)
					songService.update(song.getId(), song);
				else
					songService.save(song);
			}
		}
		artistDao.save(artist);
		return 1;
	}

	@Override
	@Transactional
	public int save(Artist artist) {
		if (artist.getName() == null || artist.getName() == "")
			return -2;
		if (findById(artist.getId()) != null)
			return -1;
		if (artist.getAlbums().size() > 0) {
			for (Album album : artist.getAlbums()) {
				if (album.getArtist() != artist)
					album.setArtist(artist);
				albumService.save(album);
			}
		}
		if (artist.getSongs().size() > 0) {
			for (Song song : artist.getSongs()) {
				if (song.getArtist() != artist)
					song.setArtist(artist);
				songService.save(song);
			}
		}
		artistDao.save(artist);
		return 1;
	}

	@Override
	public Artist findbyName(String name) {
		return artistDao.findByName(name);
	}

	@Override
	public List<Artist> searchByName(String name) {
		return artistDao.searchByName(name);
	}

}
