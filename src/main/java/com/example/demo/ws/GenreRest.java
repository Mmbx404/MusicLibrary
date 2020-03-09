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

import com.example.demo.bean.Genre;
import com.example.demo.service.facade.GenreService;

@RestController
@RequestMapping("/MusicLibrary-Api/Genre")
public class GenreRest {
	@Autowired
	GenreService genreService;
	@GetMapping("/findAll")
	public List<Genre> findAll() {
		return genreService.findAll();
	}
	@GetMapping("/findById/Id/{id}")
	public Genre findById(@PathVariable("id") Long id) {
		return genreService.findById(id);
	}
	@DeleteMapping("/deleteAll")
	public int deleteAll() {
		return genreService.deleteAll();
	}
	@DeleteMapping("/deleteById/Id/{id}")
	public int deleteById(@PathVariable("id") Long id) {
		return genreService.deleteById(id);
	}
	@PutMapping("/update/Id/{id}")
	public int update(@PathVariable("id") Long id,@RequestBody Genre genre) {
		return genreService.update(id, genre);
	}
	@PostMapping("/save")
	public int save(@RequestBody Genre genre) {
		return genreService.save(genre);
	}
	
}
