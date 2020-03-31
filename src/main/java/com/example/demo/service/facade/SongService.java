package com.example.demo.service.facade;

import java.util.Date;
import java.util.List;

import com.example.demo.bean.Song;

public interface SongService {
	public List<Song> findAll();
	public Song findById(Long id);
	public int deleteAll();
	public int deleteById(Long id);
	public int update(String libelle,Song song);
	public int save(Song song);
	public Song findByLibelle(String libelle);
	public List<Song> findByReleaseDate(Date releaseDate);
	public List<Song> findByAlbumId(Long id);
	public List<Song> findByArtistId(Long id);

	public List<Song> findByGenreId(Long id);
	List<Song> searchByLibelle(String libelle);
}
