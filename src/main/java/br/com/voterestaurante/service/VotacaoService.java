package br.com.voterestaurante.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.voterestaurante.dao.VotacaoDAO;
import br.com.voterestaurante.entity.Restaurante;
import br.com.voterestaurante.entity.Votacao;
import br.com.voterestaurante.to.VotacaoTO;

@Service
public class VotacaoService {
	
	@Autowired
	RestauranteService restauranteService;
	
	@Autowired
	VotacaoDAO votacaoDAO;
	
	public void salvarVotacao(Votacao votacao){
		votacaoDAO.salvar(votacao);
	}

	public List<VotacaoTO> montarListaOpcoesVoto(){
		List<Restaurante> restaurantes = restauranteService.listAll();
		List<VotacaoTO> listaRestaurantesVotacao = new ArrayList<VotacaoTO>();
		
		while (restaurantes.size() > 1) {
			Restaurante restaurante = restaurantes.remove(0);
			for (Restaurante restauranteInList : restaurantes) {
				VotacaoTO votacaoTO = new VotacaoTO(restaurante, restauranteInList);
				listaRestaurantesVotacao.add(votacaoTO);
			}
		}
		return listaRestaurantesVotacao;
	}
}
