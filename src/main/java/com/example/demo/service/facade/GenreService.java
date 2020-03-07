package com.example.demo.service.facade;

import java.util.List;

import com.example.demo.bean.Genre;

public interface GenreService {
	public List<Genre> findAll();
	public Genre findById(Long id);
	public int deleteAll();
	public int deleteById(Long id);
	public int update(Long id,Genre genre);
	public int save(Genre genre);
}
