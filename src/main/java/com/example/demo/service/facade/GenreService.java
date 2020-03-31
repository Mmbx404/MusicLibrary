package com.example.demo.service.facade;

import java.util.List;

import com.example.demo.bean.Genre;

public interface GenreService {
	public List<Genre> findAll();
	public Genre findById(Long id);
	public int deleteAll();
	public int deleteById(Long id);
	public int update(String libelle,Genre genre);
	public int save(Genre genre);
	public Genre findByLibelle(String libelle);
}
