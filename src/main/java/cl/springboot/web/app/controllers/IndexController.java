package cl.springboot.web.app.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;



import cl.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("app")
public class IndexController {
	
	@Value("${titulo.index}")
	private String tituloIndex;
	
	@Value("${titulo.perfil}")
	private String tituloPerfil;
	
	@Value("${titulo.listar}")
	private String tituloListar;
	
	
	@GetMapping({"/index","/","","/home"})
	public String index(Model model) {
		model.addAttribute("titulo", this.tituloIndex);
		return "index";
		
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Juan Daniel");
		usuario.setApellido("Muñoz Queupul");
//		usuario.setEmail("juandaniel@gmail.com");
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", this.tituloPerfil.concat(usuario.getNombre()));
		
		return "perfil";
		
	}

	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", this.tituloListar);
		return "listar";
		
	}
	
	@ModelAttribute("lista")
	public List<Usuario> poblarUsuarios(){
		Usuario usuario = new Usuario();
		usuario.setNombre("Juan Daniel");
		usuario.setApellido("Muñoz Queupul");
		usuario.setEmail("juandaniel@gmail.com");
		
		Usuario usuario2 = new Usuario();
		usuario2.setNombre("Francisco Adrian");
		usuario2.setApellido("Vera Cornejo");
		usuario2.setEmail("pancho@gmail.com");
		
		return  Arrays.asList(usuario,usuario2);
	}

	
	
	
}
