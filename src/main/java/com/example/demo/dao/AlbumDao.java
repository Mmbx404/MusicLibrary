package com.example.demo.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.Album;

@Repository
public interface AlbumDao extends JpaRepository<Album, Long> {
	public Album findByLibelle(String libelle);

	public List<Album> findByReleaseDate(Date releaseDate);

	public List<Album> findByArtistId(Long id);

	@Query(value = "SELECT * FROM ALBUM u WHERE u.libelle LIKE %?%", nativeQuery = true)
	public List<Album> searchByLibelle(String libelle);
}
