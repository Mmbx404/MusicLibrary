package com.example.demo.service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Genre;
import com.example.demo.bean.Song;
import com.example.demo.dao.GenreDao;
import com.example.demo.exception.TransactionFailedException;
import com.example.demo.service.facade.GenreService;
import com.example.demo.service.facade.SongService;

@Service
public class GenreServiceImpl implements GenreService {
	@Autowired
	GenreDao genreDao;
	@Autowired
	SongService songService;

	@Override
	public List<Genre> findAll() {
		return genreDao.findAll();
	}

	@Override
	public Genre findById(Long id) {
		if (genreDao.findById(id).isPresent())
			return genreDao.findById(id).get();
		else
			return null;
	}

	@Override
	public int deleteAll() {
		genreDao.deleteAll();
		if (findAll() == null)
			return 1;
		else
			return -1;
	}

	@Override
	public int deleteById(Long id) {
		genreDao.deleteById(id);
		if (findById(id) == null)
			return 1;
		else
			return -1;
	}

	@Override
	@Transactional
	public int update(String libelle, Genre genre) {
		if (findByLibelle(libelle) == null)
			throw new TransactionFailedException("Given genre doesn't exists in database");
		if (genre.getLibelle() == null || genre.getLibelle() == "")
			throw new TransactionFailedException("Libelle should not be empty or null");
		genreDao.save(genre);
		if (genre.getSongs().size() > 0) {
			for (Song song : genre.getSongs()) {
				if (song.getGenre() != genre)
					song.setGenre(genre);
				if (songService.findByLibelle(song.getLibelle()) != null)
					songService.update(song.getLibelle(), song);
				songService.save(song);
			}
		}
		return 1;
	}

	@Override
	@Transactional
	public int save(Genre genre) {
		if (findById(genre.getId()) != null)
			throw new TransactionFailedException("Given genre already exists in database");
		if (genre.getLibelle() == null || genre.getLibelle() == "")
			throw new TransactionFailedException("Libelle should not be empty or null");
		genreDao.save(genre);
		if (genre.getSongs().size() > 0) {
			for (Song song : genre.getSongs()) {
				if (song.getGenre() != genre)
					song.setGenre(genre);
				if (songService.findByLibelle(song.getLibelle()) != null)
					songService.update(song.getLibelle(), song);
				songService.save(song);
			}
		}
		return 1;
	}

	@Override
	public Genre findByLibelle(String libelle) {
		return genreDao.findByLibelle(libelle);
	}

}
