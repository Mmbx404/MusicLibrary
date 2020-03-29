package com.example.demo.service.facade;

import java.util.List;

import com.example.demo.bean.PlayList;

public interface PlayListService {
	public List<PlayList> findAll();
	public PlayList findById(Long id);
	public int deleteAll();
	public int deleteById(Long id);
	public int update(Long id,PlayList playList);
	public int save(PlayList playList);
	public PlayList findByLibelle(String libelle);
	public List<PlayList> searchByLibelle(String libelle);
}
