package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.example.demo.bean.Artist;
@Repository
public interface ArtistDao extends JpaRepository<Artist, Long> {
	public Artist findByName(String name);
	@Query(value = "SELECT * FROM ARTIST u WHERE u.name LIKE %?%", nativeQuery = true)
	public List<Artist> searchByName(String name);
}
