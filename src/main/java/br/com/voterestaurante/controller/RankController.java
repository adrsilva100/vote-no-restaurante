package br.com.voterestaurante.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.voterestaurante.entity.Usuario;
import br.com.voterestaurante.service.RankService;
import br.com.voterestaurante.service.UsuarioService;
import br.com.voterestaurante.to.RankTO;
import br.com.voterestaurante.to.RankUserTO;

@Controller
@RequestMapping(value="/rank")
public class RankController {
	
	@Autowired
	private RankService rankService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value="/visualizar")
	public ModelAndView send(HttpServletRequest request){
		ModelMap atributos = new ModelMap();
		List<RankTO> rankGlobal = rankService.rankRestaurantesGlobal();
		
		Usuario usuario = usuarioService.findById(Long.valueOf(request.getParameter("usuarioId")));
		if (usuario == null) {
			atributos.addAttribute("errorMessage", "Usuário não encontrado.");
			return new ModelAndView("/rank/visualizar");
		}		
		
		RankUserTO rankByUsuario = rankService.rankRestaurantesByUsuario(usuario);
		atributos.addAttribute("rankGlobal", rankGlobal);
		atributos.addAttribute("rankByUsuario", rankByUsuario);
		
		return new ModelAndView("/rank/visualizar", atributos);
	}
	
}
