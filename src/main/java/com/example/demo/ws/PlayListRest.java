package com.example.demo.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.PlayList;
import com.example.demo.service.facade.PlayListService;

@RestController
@RequestMapping("/MusicLibrary-Api/PlayList")
public class PlayListRest {
	@Autowired
	PlayListService playListService;
	@GetMapping("/findAll")
	public List<PlayList> findAll() {
		return playListService.findAll();
	}
	@GetMapping("/findById/Id/{id}")
	public PlayList findById(@PathVariable("id") Long id) {
		return playListService.findById(id);
	}
	@DeleteMapping("/deleteAll")
	public int deleteAll() {
		return playListService.deleteAll();
	}
	@DeleteMapping("/deleteById/Id/{id}")
	public int deleteById(@PathVariable("id") Long id) {
		return playListService.deleteById(id);
	}
	@PutMapping("/update/Id/{id}")
	public int update(@PathVariable("id") Long id,@RequestBody PlayList playList) {
		return playListService.update(id, playList);
	}
	@PostMapping("/save")
	public int save(@RequestBody PlayList playList) {
		return playListService.save(playList);
	}
	@GetMapping("/findByLibelle/Libelle/{libelle}")
	public PlayList findByLibelle(@PathVariable("libelle") String libelle) {
		return playListService.findByLibelle(libelle);
	}
	
}
