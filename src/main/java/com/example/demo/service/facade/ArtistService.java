package com.example.demo.service.facade;

import java.util.List;

import com.example.demo.bean.Artist;

public interface ArtistService {
	public List<Artist> findAll();
	public Artist findById(Long id);
	public int deleteAll();
	public int deleteById(Long id);
	public int update(Long id,Artist artist);
	public int save(Artist artist);
	public Artist findbyName(String name);
	List<Artist> searchByName(String name);
}
