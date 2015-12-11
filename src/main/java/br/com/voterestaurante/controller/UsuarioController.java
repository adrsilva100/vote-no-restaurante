package br.com.voterestaurante.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.voterestaurante.entity.Usuario;
import br.com.voterestaurante.entity.Votacao;
import br.com.voterestaurante.service.UsuarioService;
import br.com.voterestaurante.service.VotacaoService;

@Controller
@RequestMapping(value="/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	VotacaoService votacaoService;
	
	@RequestMapping(value="/registrar")
	public ModelAndView register(HttpServletRequest request){
		return new ModelAndView("/usuario/registrar");
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/salvar")
	public ModelAndView salvar(HttpServletRequest request){
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		Usuario usuario = new Usuario(null, nome, email);
		
		Usuario usuarioBD = usuarioService.findByNomeAndEmail(usuario.getNome(), usuario.getEmail());
		if(usuarioBD == null){
			usuarioService.salvar(usuario);
		}else{
			usuario = usuarioBD;
		}
		
		List<Votacao> listaVotos = (List<Votacao>) request.getSession().getAttribute("listaVotos");
		for (Votacao votacao : listaVotos) {
			votacao.setUsuario(usuario);
			votacaoService.salvarVotacao(votacao);
		}
		
		return new ModelAndView("redirect:/rank/visualizar?usuarioId=" + usuario.getId());
	}
}
