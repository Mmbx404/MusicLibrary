package com.example.demo.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.bean.Song;

public interface SongDao extends JpaRepository<Song, Long> {
	public Song findByLibelle(String libelle);
	public List<Song> findByReleaseDate(Date releaseDate);
	public List<Song> findByAlbumId(Long id);
	public List<Song> findByArtistId(Long id);
	public List<Song> findByPlayListSongsPlayListId(Long id);
	public List<Song> findByGenreId(Long id);
}
