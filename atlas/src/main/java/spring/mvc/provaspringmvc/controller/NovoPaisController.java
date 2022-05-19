package spring.mvc.provaspringmvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.provaspringmvc.dto.RequisicaoNovoPais;
import spring.mvc.provaspringmvc.model.Pais;
import spring.mvc.provaspringmvc.repository.PaisRepository;

@Controller
@RequestMapping("pais")
public class NovoPaisController {

	@Autowired
	private PaisRepository paisRepository;
	
	@GetMapping("formulario")
	public String formulario(RequisicaoNovoPais requisicao) {
		return "formulario";
	}
	
	@PostMapping("novo")
	public String novo(@Valid RequisicaoNovoPais requisicao, BindingResult result) {
		if(result.hasErrors()) {
			return "formulario";
		}
		
		Pais pais = requisicao.toPais();
		paisRepository.save(pais);
		
		return "redirect:/home";
	}
}
