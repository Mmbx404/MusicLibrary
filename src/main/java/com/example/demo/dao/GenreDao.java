package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.example.demo.bean.Genre;

public interface GenreDao extends JpaRepository<Genre, Long> {
	public Genre findByLibelle(String libelle);
	@Query(value = "SELECT * FROM GENRE u WHERE u.libelle LIKE %?%", nativeQuery = true)
	public List<Genre> searchByName(String libelle);
}
