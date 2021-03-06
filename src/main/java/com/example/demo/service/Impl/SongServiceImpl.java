package com.example.demo.service.Impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.bean.PlayList;
import com.example.demo.bean.Song;
import com.example.demo.dao.SongDao;
import com.example.demo.exception.FileStorageException;
import com.example.demo.exception.TransactionFailedException;
import com.example.demo.service.facade.AlbumSerivce;
import com.example.demo.service.facade.ArtistService;
import com.example.demo.service.facade.GenreService;
import com.example.demo.service.facade.PlayListService;
import com.example.demo.service.facade.SongService;
import com.example.demo.utils.FileStorageUtil;

@Service
public class SongServiceImpl implements SongService {
	@Autowired
	SongDao songDao;
	@Autowired
	AlbumSerivce albumService;
	@Autowired
	ArtistService artistService;
	@Autowired
	GenreService genreService;
	@Autowired
	PlayListService playListService;

	@Override
	public List<Song> findAll() {
		return songDao.findAll();
	}

	@Override
	public Song findById(Long id) {
		if (songDao.findById(id).isPresent())
			return songDao.findById(id).get();
		else
			return null;
	}

	@Override
	public int deleteAll() {
		songDao.deleteAll();
		if (findAll() == null)
			return 1;
		else
			return -1;
	}

	@Override
	public int deleteById(Long id) {
		songDao.deleteById(id);
		if (findById(id) == null)
			return 1;
		else
			return -1;
	}

	@Override
	@Transactional
	public int update(String libelle, Song song) {
		if (findByLibelle(song.getLibelle()) == null)
			throw new TransactionFailedException("Song doesn't exist in database");
		if (artistService.findbyName(song.getArtist().getName()) == null || song.getArtist() == null
				|| genreService.findByLibelle(song.getGenre().getLibelle()) == null || song.getGenre() == null
				|| albumService.findByLibelle(song.getAlbum().getLibelle()) == null || song.getAlbum() == null)
			throw new TransactionFailedException("save error");
		if (song.getLibelle() == null || song.getLibelle() == "" || song.getReleaseDate() == null)
			throw new TransactionFailedException("Libelle and Release date should not be empty or null");
		song.setGenre(genreService.findByLibelle(song.getGenre().getLibelle()));
		song.setAlbum(albumService.findByLibelle(song.getAlbum().getLibelle()));
		song.setArtist(artistService.findbyName(song.getArtist().getName()));
		songDao.save(song);
		if (song.getFeaturingPlayLists().size() > 0) {
			for (PlayList playList : song.getFeaturingPlayLists()) {
				int validate = 0;
				for (Song song1 : playList.getPlayListSongs()) {
					if (song1.getLibelle() == song.getLibelle()) {
						validate = 1;
						break;
					}
				}
				if (validate != 1)
					playList.getPlayListSongs().add(song);
				if (playListService.findByLibelle(playList.getLibelle()) != null)
					playListService.update(playList.getLibelle(), playList);
				playListService.save(playList);
			}
		}
		return 1;
	}

	@Override
	@Transactional
	public int save(Song song) {
		if (findByLibelle(song.getLibelle()) != null)
			throw new TransactionFailedException("Given song already exists in database");
		if (artistService.findbyName(song.getArtist().getName()) == null || song.getArtist() == null
				|| genreService.findByLibelle(song.getGenre().getLibelle()) == null || song.getGenre() == null
				|| albumService.findByLibelle(song.getAlbum().getLibelle()) == null || song.getAlbum() == null)
			throw new TransactionFailedException("save error");
		song.setGenre(genreService.findByLibelle(song.getGenre().getLibelle()));
		song.setAlbum(albumService.findByLibelle(song.getAlbum().getLibelle()));
		song.setArtist(artistService.findbyName(song.getArtist().getName()));
		songDao.save(song);
		if (song.getLibelle() == null || song.getLibelle() == "" || song.getReleaseDate() == null)
			throw new TransactionFailedException("Libelle and Release date should not be empty or null");
		if (song.getFeaturingPlayLists().size() > 0) {
			for (PlayList playList : song.getFeaturingPlayLists()) {
				int validate = 0;
				for (Song song1 : playList.getPlayListSongs()) {
					if (song1.getLibelle() == song.getLibelle()) {
						validate = 1;
						break;
					}
				}
				if (validate != 1)
					playList.getPlayListSongs().add(song);
				if (playListService.findByLibelle(playList.getLibelle()) != null)
					playListService.update(playList.getLibelle(), playList);
				playListService.save(playList);
			}
		}
		return 1;
	}
/*	@Override
	@Transactional
	public int save(String libelle,MultipartFile file) {
		if (file != null || FileStorageUtil.fileIsAudio(file)) {
		  
			try {
				Song song= findByLibelle(libelle);
				song.setSongFile(file.getBytes());
				songDao.save(song);
				return 1;
			} catch (IOException e) {
              throw new FileStorageException("Error with file upload");
			}
	       
		}
		throw new FileStorageException("Error with file type/null");
	} */

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

	@Override
	public List<Song> searchByLibelle(String libelle) {
		return songDao.searchByLibelle(libelle);
	}

}
