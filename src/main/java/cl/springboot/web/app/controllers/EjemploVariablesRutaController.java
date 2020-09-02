package cl.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesRutaController {
	
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("titulo", "enviando parametros");
		return "variables/index";
	}
	
	@GetMapping("/string/{texto}")
	public String variable(@PathVariable String texto, Model model) {
		
		model.addAttribute("titulo", "recibiendo parametros con la anotación @PathVariable");
		
		model.addAttribute("resultado", "El paramento pasado es : ".concat(texto));
		
		return "variables/ver";
	}

	@GetMapping("/string/{texto}/{numero}")
	public String variable(@PathVariable String texto, @PathVariable Integer numero, Model model) {
		
		model.addAttribute("titulo", "recibiendo parametros con la anotación @PathVariable");
		
		model.addAttribute("resultado", "El paramento pasado es : "
				.concat(texto).concat(" numero es : ")
				.concat(String.valueOf(numero)));
		
		return "variables/ver";
	}
}
