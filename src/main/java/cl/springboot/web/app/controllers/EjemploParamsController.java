package cl.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("titulo", "recibir parametros desde un link");
		return "params/index";
		
	}
	
	@GetMapping("/string")
	public String param(@RequestParam(name = "texto",defaultValue = "nada") String texto, Model model) {
		
		model.addAttribute("resultado", "El paramentos pasado es : ".concat(texto));
		model.addAttribute("titulo", "Recibir parámetros del request HTTP GET");
		
		return "params/ver";
		
	}
	
	@GetMapping("/mix-params")
	public String param(@RequestParam String saludo, @RequestParam Integer numero, Model model) {
		
		model.addAttribute("resultado", "El paramento pasado es : "
							.concat(saludo).concat(" numero es : ")
							.concat(String.valueOf(numero)));
		model.addAttribute("titulo", "Recibir parámetros distintos del request HTTP GET");
		
		return "params/ver";
		
	}

	@GetMapping("/mix-params-request")
	public String param(HttpServletRequest request, Model model) {
		String saludo = request.getParameter("saludo");
		Integer numero = Integer.parseInt(request.getParameter("numero")); 
		
		model.addAttribute("resultado", "El paramento pasado es : "
							.concat(saludo).concat(" numero es : ")
							.concat(String.valueOf(numero)));
		model.addAttribute("titulo", "Recibir parámetros distintos del request HTTP GET");
		
		return "params/ver";
		
	}
	
	

}
