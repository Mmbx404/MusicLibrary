package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.bean.Genre;

public interface GenreDao extends JpaRepository<Genre, Long> {
	public Genre findByLibelle(String libelle);
}
