package com.example.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Genre;
import com.example.demo.dao.GenreDao;
import com.example.demo.service.facade.GenreService;

@Service
public class GenreServiceImpl implements GenreService {
	@Autowired
	GenreDao genreDao;
	@Override
	public List<Genre> findAll() {
		return genreDao.findAll();
	}

	@Override
	public Genre findById(Long id) {
		if (genreDao.findById(id).isPresent()) return genreDao.findById(id).get();
		else return null;
	}

	@Override
	public int deleteAll() {
		genreDao.deleteAll();
		if (findAll() == null) return 1;
		else return -1;
	}

	@Override
	public int deleteById(Long id) {
		genreDao.deleteById(id);
		if (findById(id) == null) return 1;
		else return -1;
	}

	@Override
	public int update(Long id, Genre genre) {
		if (findById(id) != null) {
			genreDao.save(genre);
			return 1;
		} else return -1;
	}

	@Override
	public int save(Genre genre) {
		if (findById(genre.getId()) == null) {
			genreDao.save(genre);
			return 1;
		} else return -1;
	}

}
