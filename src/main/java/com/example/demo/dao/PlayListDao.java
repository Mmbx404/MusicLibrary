package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.bean.PlayList;

public interface PlayListDao extends JpaRepository<PlayList, Long> {
	public PlayList findByLibelle(String libelle);
}
