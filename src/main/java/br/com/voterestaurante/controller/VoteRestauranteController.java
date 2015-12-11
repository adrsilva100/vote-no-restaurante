package br.com.voterestaurante.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.voterestaurante.entity.Restaurante;
import br.com.voterestaurante.entity.Votacao;
import br.com.voterestaurante.service.RestauranteService;
import br.com.voterestaurante.service.VotacaoService;
import br.com.voterestaurante.to.VotacaoTO;

@Controller
@RequestMapping(value="/votacao")
public class VoteRestauranteController {
	
	@Autowired
	private VotacaoService votacaoService;
	
	@Autowired
	private RestauranteService restauranteService;
	
	@RequestMapping(value={"/restaurante", "/"})
	public ModelAndView iniciarVotacao(HttpServletRequest request){
		List<VotacaoTO> listaOpcoesVotacao = votacaoService.montarListaOpcoesVoto();
		List<Votacao> listaVotos = new ArrayList<Votacao>();
		request.getSession().setAttribute("listaVotos", listaVotos);
		
		return selecionaDoisRestaurantesParaVotacao(request, listaOpcoesVotacao, listaVotos);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/votar")
	public ModelAndView computarVoto(HttpServletRequest request){
		List<VotacaoTO> listaOpcoesVotacao = (List<VotacaoTO>) request.getSession().getAttribute("listaOpcoesVotacao");
		List<Votacao> listaVotos = (List<Votacao>) request.getSession().getAttribute("listaVotos");
		VotacaoTO opcaoVotacao = (VotacaoTO) request.getSession().getAttribute("opcaoVotacaoSelecionada");
		Long restauranteVotadoId = Long.parseLong(request.getParameter("restauranteSelecionadoId"));
		Restaurante restauranteVotado = restauranteService.get(restauranteVotadoId);
		Votacao votacao = new Votacao(null, opcaoVotacao.getOpcao1(), opcaoVotacao.getOpcao2(), restauranteVotado, new Date(), null);
		listaVotos.add(votacao);
		
		return selecionaDoisRestaurantesParaVotacao(request, listaOpcoesVotacao, listaVotos);
	}
	
	private ModelAndView selecionaDoisRestaurantesParaVotacao(HttpServletRequest request, List<VotacaoTO> listaOpcoesVotacao, List<Votacao> listaVotos) {
		
		if(listaOpcoesVotacao != null && listaOpcoesVotacao.size() > 0){
			int index = new Random().nextInt( listaOpcoesVotacao.size() );
			VotacaoTO opcaoVotacaoSelecionada = listaOpcoesVotacao.remove(index);
			request.getSession().setAttribute("listaOpcoesVotacao", listaOpcoesVotacao);
			request.getSession().setAttribute("opcaoVotacaoSelecionada", opcaoVotacaoSelecionada);
			
			return new ModelAndView("votacao/votarRestaurante", "opcaoVotacaoSelecionada", opcaoVotacaoSelecionada);
			
		}else{
			request.getSession().setAttribute("listaVotos", listaVotos);
			return new ModelAndView("redirect:/usuario/registrar");
		}
	}
}
