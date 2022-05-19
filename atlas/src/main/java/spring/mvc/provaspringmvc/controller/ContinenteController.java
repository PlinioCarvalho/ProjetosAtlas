package spring.mvc.provaspringmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.provaspringmvc.model.Pais;
import spring.mvc.provaspringmvc.repository.PaisRepository;

@Controller
@RequestMapping("/continente")
public class ContinenteController {

	@Autowired
	private PaisRepository paisRepository;
	
	@GetMapping("/america")
	public String america(Model model) {
		List<Pais> paises = paisRepository.findByContinente("america");
		model.addAttribute("paises", paises);
		
		return "continentes/america";
	}
	
	@GetMapping("/europa")
	public String europa(Model model) {
		List<Pais> paises = paisRepository.findByContinente("europa");
		model.addAttribute("paises", paises);
		
		return "continentes/europa";
	}
	
	@GetMapping("/africa")
	public String africa(Model model) {
		List<Pais> paises = paisRepository.findByContinente("africa");
		model.addAttribute("paises", paises);
		
		return "continentes/africa";
	}
	
	@GetMapping("/oceania")
	public String oceania(Model model) {
		List<Pais> paises = paisRepository.findByContinente("oceania");
		model.addAttribute("paises", paises);
		
		return "continentes/oceania";
	}
	
	@GetMapping("/asia")
	public String asia(Model model) {
		List<Pais> paises = paisRepository.findByContinente("asia");
		model.addAttribute("paises", paises);
		
		return "continentes/asia";
	}
}
