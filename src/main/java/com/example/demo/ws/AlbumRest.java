package com.example.demo.ws;

import java.util.Date;
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

import com.example.demo.bean.Album;
import com.example.demo.service.facade.AlbumSerivce;

@RestController
@RequestMapping("/MusicLibrary-Api/Album")
public class AlbumRest {
	@Autowired
	AlbumSerivce albumService;
	@GetMapping("/findAll")
	public List<Album> findAll() {
		return albumService.findAll();
	}
	@GetMapping("/findById/id/{id}")
	public Album findById(@PathVariable("id") Long id) {
		return albumService.findById(id);
	}
	@DeleteMapping("/deleteAll")
	public int deleteAll() {
		return albumService.deleteAll();
	}
	@DeleteMapping("/deleteById/id/{id}")
	public int deleteById(@PathVariable("id") Long id) {
		return albumService.deleteById(id);
	}
	@PutMapping("/update/id/{id}")
	public int update(@PathVariable("id") Long id,@RequestBody Album album) {
		return albumService.update(id, album);
	}
	@PostMapping("/save")
	public int save(@RequestBody Album album) {
		return albumService.save(album);
	}
	@GetMapping("/findByLibelle/Libelle/{libelle}")
	public Album findByLibelle(@PathVariable("libelle") String libelle) {
		return albumService.findByLibelle(libelle);
	}
	@GetMapping("/findByReleaseDate/ReleaseDate/{releaseDate}")
	public List<Album> findByReleaseDate(@PathVariable("releaseDate") Date releaseDate) {
		return albumService.findByReleaseDate(releaseDate);
	}
	@GetMapping("/findByArtistId/ArtistId/{id}")
	public List<Album> findByArtistId(@PathVariable("id") Long id) {
		return albumService.findByArtistId(id);
	}
	
}
