package spring.mvc.provaspringmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.provaspringmvc.dto.Pesquisa;
import spring.mvc.provaspringmvc.model.Pais;
import spring.mvc.provaspringmvc.repository.PaisRepository;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private PaisRepository paisRepository;
	
	@GetMapping
	public String home(Pesquisa requisicao) {
		return "home";
	}
	
	@GetMapping("/pesquisa")
	public String pesquisar(Pesquisa requisicao) {
		return "pesquisa/encontrado";
	}
	
	@PostMapping("/pesquisa")
	public String pesquisar(Pesquisa requisicao, Model model) {
		Pais pais = paisRepository.findByNome(requisicao.getNomePesquisa());
		if(pais == null) {
			return "pesquisa/naoEncontrado";
		}
		model.addAttribute("pais", pais);
		
		return "pesquisa/encontrado";
	}
	
}
