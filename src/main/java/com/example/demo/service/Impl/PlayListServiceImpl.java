package com.example.demo.service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.PlayList;
import com.example.demo.bean.Song;
import com.example.demo.dao.PlayListDao;
import com.example.demo.exception.TransactionFailedException;
import com.example.demo.service.facade.PlayListService;
import com.example.demo.service.facade.SongService;

@Service
public class PlayListServiceImpl implements PlayListService {
	@Autowired
	PlayListDao playListDao;
	@Autowired
	SongService songService;

	@Override
	public List<PlayList> findAll() {
		return playListDao.findAll();
	}

	@Override
	public PlayList findById(Long id) {
		if (playListDao.findById(id).isPresent())
			return playListDao.findById(id).get();
		else
			return null;
	}

	@Override
	public int deleteAll() {
		playListDao.deleteAll();
		if (findAll() == null)
			return 1;
		else
			return -1;
	}

	@Override
	public int deleteById(Long id) {
		playListDao.deleteById(id);
		if (findById(id) == null)
			return 1;
		else
			return -1;
	}

	@Override
	@Transactional
	public int update(String libelle, PlayList playList) {
		if (findByLibelle(playList.getLibelle()) == null)
			throw new TransactionFailedException("PlayList doesn't exists in database");
		if (playList.getLibelle() == null || playList.getLibelle() == "")
			throw new TransactionFailedException("Libelle should not be empty or null");
		playListDao.save(playList);
		if (playList.getPlayListSongs().size() > 0) {
			for (Song song : playList.getPlayListSongs()) {
				int validate = 0;
				for (PlayList playList1 : song.getFeaturingPlayLists()) {
					if (playList1.getLibelle() == playList.getLibelle()) {
						validate = 1;
						break;
					}
				}
				if (validate != 1)
					song.getFeaturingPlayLists().add(playList);
				if (songService.findByLibelle(song.getLibelle()) != null)
					songService.update(song.getLibelle(), song);
				songService.save(song);
			}
		}
		return 1;
	}

	@Override
	@Transactional
	public int save(PlayList playList) {
		if (findByLibelle(playList.getLibelle()) != null)
			throw new TransactionFailedException("PlayList Already exists in database");
		if (playList.getLibelle() == null || playList.getLibelle() == "")
			throw new TransactionFailedException("Libelle should not be empty or null");
		playListDao.save(playList);
		if (playList.getPlayListSongs().size() > 0) {
			for (Song song : playList.getPlayListSongs()) {
				int validate = 0;
				for (PlayList playList1 : song.getFeaturingPlayLists()) {
					if (playList1.getLibelle() == playList.getLibelle())
						validate = 1;
				}
				if (validate != 1)
					song.getFeaturingPlayLists().add(playList);
				if (songService.findByLibelle(song.getLibelle()) != null)
					songService.update(song.getLibelle(), song);
				songService.save(song);
			}
		}
		return 1;
	}

	@Override
	public PlayList findByLibelle(String libelle) {
		return playListDao.findByLibelle(libelle);
	}

	@Override
	public List<PlayList> searchByLibelle(String libelle) {
		return playListDao.searchByLibelle(libelle);
	}

}
