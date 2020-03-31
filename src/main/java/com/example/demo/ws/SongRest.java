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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.bean.Song;
import com.example.demo.service.facade.SongService;

@RestController
@RequestMapping("/MusicLibrary-Api/Song")
public class SongRest {
	@Autowired
	SongService songService;
	@GetMapping("/findAll")
	public List<Song> findAll() {
		return songService.findAll();
	}
	@GetMapping("/findById/Id/{id}")
	public Song findById(@PathVariable("id") Long id) {
		return songService.findById(id);
	}
	@DeleteMapping("/deleteAll")
	public int deleteAll() {
		return songService.deleteAll();
	}
	@DeleteMapping("/deleteById/Id/{id}")
	public int deleteById(@PathVariable("id") Long id) {
		return songService.deleteById(id);
	}
	@PutMapping("/update/libelle/{libelle}")
	public int update(@PathVariable("libelle") String libelle,@RequestBody Song song) {
		return songService.update(libelle, song);
	}
	@PostMapping("/save")
	public int save(@RequestBody Song song) {
		return songService.save(song);
	}
	
	@PostMapping("/savesongfile/{libelle}")
	public int save(@PathVariable String libelle,@RequestParam("file") MultipartFile file) {
		return songService.save(libelle,file);
	}
	
	@GetMapping("/findByLibelle/Libelle/{libelle}")
	public Song findByLibelle(@PathVariable("") String libelle) {
		return songService.findByLibelle(libelle);
	}
	@GetMapping("/findByReleaseDate/ReleaseDate/{releaseDate}")
	public List<Song> findByReleaseDate(@PathVariable("releaseDate") Date releaseDate) {
		return songService.findByReleaseDate(releaseDate);
	}
	@GetMapping("/findByAlbumId/AlbumId/{id}")
	public List<Song> findByAlbumId(@PathVariable("id") Long id) {
		return songService.findByAlbumId(id);
	}
	@GetMapping("/findByArtistId/Id/{id}")
	public List<Song> findByArtistId(@PathVariable("id") Long id) {
		return songService.findByArtistId(id);
	}

	@GetMapping("/findByGenreId/Id/{id}")
	public List<Song> findByGenreId(@PathVariable("id") Long id) {
		return songService.findByGenreId(id);
	}
	
}
