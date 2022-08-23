package com.telusko.demo.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.servlet.ModelAndView;

import com.telusko.demo.dao.AlienRepo;
import com.telusko.demo.model.Alien;

@RestController
public class AlienController {

	@Autowired
	AlienRepo alienRepo;

	/*
	 * @RequestMapping("/home") public String home() { return "home"; }
	 */

	@RequestMapping("/home")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("home");
		List<Alien> allAlienList = (List<Alien>) alienRepo.findAll();
		mv.addObject("alienListId", allAlienList);
		return mv;
	}

	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		alienRepo.save(alien);
		return "home";
	}

	@RequestMapping("/getAllAlien")
	public ModelAndView getAllAlien() {

		System.out.println(alienRepo.findByTech("Java"));
		System.out.println(alienRepo.findByAidGreaterThan(101));
		System.out.println(alienRepo.findByTechSorted("Java"));

		ModelAndView mv = new ModelAndView("showAllAlien");
		List<Alien> allAlienList = (List<Alien>) alienRepo.findAll();
		mv.addObject("allAlienList", allAlienList);
		return mv;
	}

	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid) {
		ModelAndView mv = new ModelAndView("showAlien");
		Alien alien = alienRepo.findById(aid).orElse(new Alien());
		mv.addObject("alien", alien);
		return mv;
	}

	@RequestMapping("/updateAlien")
	public String updateAlien(Alien alien) {
		alienRepo.save(alien);
		return "home";
	}

	@RequestMapping("/deleteAlien")
	public String deleteAlien(@RequestParam int aid) {
		alienRepo.deleteById(aid);
		return "home";
	}

	// REST Configuration

	@PostMapping("/saveAlien")
	public Alien saveAlien(@RequestBody Alien alien) {
		alienRepo.save(alien);
		return alien;
	}

	@GetMapping(path = "/aliens" /* produces = {"application/xml"} */ /* Restricted for only xml data */)
	public List<Alien> getAliens() {

		return alienRepo.findAll();
	}

	@GetMapping("/getAlien/{aid}")
	public Optional<Alien> getAlienById(@PathVariable int aid) {

		return alienRepo.findById(aid);
	}
	@PutMapping("/updateAlien")
	public Alien saveOrUpdateAlien(@RequestBody Alien alien) {
		alienRepo.save(alien);
		return alien;
	}

	@DeleteMapping("/deleteAlien/{aid}")
	public String deletesAlien(@PathVariable int aid) {
		Alien alien = alienRepo.getReferenceById(aid);
		alienRepo.delete(alien);
		//alienRepo.deleteById(aid);
		return "Deleted";
	}

}
