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

import com.example.demo.bean.Artist;
import com.example.demo.service.facade.ArtistService;

@RestController
@RequestMapping("/MusicLibrary-Api/Artist")
public class ArtistRest {
	@Autowired
	ArtistService artistService;
	@GetMapping("/findAll")
	public List<Artist> findAll() {
		return artistService.findAll();
	}
	@GetMapping("/findById/Id/{id}")
	public Artist findById(@PathVariable("id") Long id) {
		return artistService.findById(id);
	}
	@DeleteMapping("/deleteAll")
	public int deleteAll() {
		return artistService.deleteAll();
	}
	@DeleteMapping("/deleteById/Id/{id}")
	public int deleteById(@PathVariable("id") Long id) {
		return artistService.deleteById(id);
	}
	@PutMapping("/update/name/{name}")
	public int update(@PathVariable("name") String name,@RequestBody Artist artist) {
		return artistService.update(name, artist);
	}
	@PostMapping("/save")
	public int save(@RequestBody Artist artist) {
		return artistService.save(artist);
	}
	@GetMapping("/findByName/Name/{name}")
	public Artist findbyName(@PathVariable("name") String name) {
		return artistService.findbyName(name);
	}
	
}
