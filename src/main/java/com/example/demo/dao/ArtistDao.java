package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.Artist;
@Repository
public interface ArtistDao extends JpaRepository<Artist, Long> {
	public Artist findByName(String name);
}
