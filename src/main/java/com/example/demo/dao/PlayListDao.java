package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.bean.Genre;
import com.example.demo.bean.PlayList;

public interface PlayListDao extends JpaRepository<PlayList, Long> {
	public PlayList findByLibelle(String libelle);
	@Query(value = "SELECT * FROM Play_list u WHERE u.libelle LIKE %?%", nativeQuery = true)
	public List<PlayList> searchByLibelle(String libelle);
}
