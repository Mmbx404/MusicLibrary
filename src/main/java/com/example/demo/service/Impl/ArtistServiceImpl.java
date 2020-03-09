package com.example.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Artist;
import com.example.demo.dao.ArtistDao;
import com.example.demo.service.facade.ArtistService;
@Service
public class ArtistServiceImpl implements ArtistService {
	@Autowired
	ArtistDao artistDao;
	@Override
	public List<Artist> findAll() {
		return artistDao.findAll();
	}

	@Override
	public Artist findById(Long id) {
		if (artistDao.findById(id).isPresent()) return artistDao.findById(id).get();
		else return null;
	}

	@Override
	public int deleteAll() {
		artistDao.deleteAll();
		if (findAll() == null) return 1;
		else return -1;
	}

	@Override
	public int deleteById(Long id) {
		artistDao.deleteById(id);
		if (findById(id) == null ) return 1;
		else return -1;
	}

	@Override
	public int update(Long id, Artist artist) {
		if (findById(id) != null ) {
			artistDao.save(artist);
			return 1;
		}
		else return -1;
	}

	@Override
	public int save(Artist artist) {
		if (findById(artist.getId()) == null) {
			artistDao.save(artist);
			return 1;
		}
		else return -1;
	}

	@Override
	public Artist findbyName(String name) {
		return null;
	}

}
