package com.example.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.PlayList;
import com.example.demo.dao.PlayListDao;
import com.example.demo.service.facade.PlayListService;

@Service
public class PlayListServiceImpl implements PlayListService {
	@Autowired
	PlayListDao playListDao;
	@Override
	public List<PlayList> findAll() {
		return playListDao.findAll();
	}

	@Override
	public PlayList findById(Long id) {
		if (playListDao.findById(id).isPresent()) return playListDao.findById(id).get();
		else return null;
	}

	@Override
	public int deleteAll() {
		playListDao.deleteAll();
		if (findAll() == null) return 1;
		else return -1;
	}

	@Override
	public int deleteById(Long id) {
		playListDao.deleteById(id);
		if (findById(id) == null) return 1;
		else return -1;
	}

	@Override
	public int update(Long id, PlayList playList) {
		if (findById(id) != null) {
			playListDao.save(playList);
			return 1;
		} else return -1;
	}

	@Override
	public int save(PlayList playList) {
		if (findById(playList.getId()) == null) {
			playListDao.save(playList);
			return 1;
		} else return -1;
	}

	@Override
	public PlayList findByLibelle(String libelle) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
