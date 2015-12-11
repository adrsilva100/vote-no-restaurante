package br.com.voterestaurante.dao;

import java.util.List;

import br.com.voterestaurante.entity.Usuario;
import br.com.voterestaurante.to.RankTO;
import br.com.voterestaurante.to.RankUserTO;

public interface RankDAO {
	
	public List<RankTO> rankRestaurantesGlobal();
	public RankUserTO rankRestaurantesByUser(Usuario usuario);
}
