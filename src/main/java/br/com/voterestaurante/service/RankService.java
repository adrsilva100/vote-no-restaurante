package br.com.voterestaurante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.voterestaurante.dao.RankDAO;
import br.com.voterestaurante.entity.Usuario;
import br.com.voterestaurante.to.RankTO;
import br.com.voterestaurante.to.RankUserTO;

@Service
public class RankService {

	@Autowired
	RankDAO rankDAO;
	
    public List<RankTO> rankRestaurantesGlobal(){
    	return rankDAO.rankRestaurantesGlobal();
    }
    
    public RankUserTO rankRestaurantesByUsuario(Usuario usuario){
    	return rankDAO.rankRestaurantesByUser(usuario);
    }
}
