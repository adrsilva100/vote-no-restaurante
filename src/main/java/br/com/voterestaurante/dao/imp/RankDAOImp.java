package br.com.voterestaurante.dao.imp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.voterestaurante.dao.RankDAO;
import br.com.voterestaurante.dao.RestauranteDAO;
import br.com.voterestaurante.entity.Restaurante;
import br.com.voterestaurante.entity.Usuario;
import br.com.voterestaurante.to.RankTO;
import br.com.voterestaurante.to.RankUserTO;

@Repository
@Transactional
public class RankDAOImp implements RankDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	RestauranteDAO restauranteDAO;
	
	public RankDAOImp(){}
	
	@SuppressWarnings("unchecked")
	public List<RankTO> rankRestaurantesGlobal() {
		
		Query query = entityManager.createNativeQuery(
														"SELECT COUNT(ID) as QTD_VOTOS, RESTAURANTEESCOLHIDO_ID  "
													  + " FROM TB_VOTACAO "
													  + "WHERE RESTAURANTEESCOLHIDO_ID IS NOT NULL "
													  + "GROUP BY RESTAURANTEESCOLHIDO_ID "
													  + "ORDER BY QTD_VOTOS DESC ");

		List<Object[]> resultado = query.getResultList();
		List<RankTO> listaRankTO = new ArrayList<RankTO>(); 
		
		for (Object[] obj : resultado) {
			Restaurante restaurante = restauranteDAO.getById(Long.valueOf(String.valueOf(obj[1])));
			RankTO rankTO = new RankTO(Long.valueOf(String.valueOf(obj[0])), restaurante);
			listaRankTO.add(rankTO);
		}
		
    	return listaRankTO;
	}
	
	@SuppressWarnings("unchecked")
	public RankUserTO rankRestaurantesByUser(Usuario usuario){
		Query query = entityManager.createNativeQuery(
				  "SELECT COUNT(ID) as QTD_VOTOS, RESTAURANTEESCOLHIDO_ID "
				+ " FROM TB_VOTACAO "
				+ "WHERE RESTAURANTEESCOLHIDO_ID IS NOT NULL "
				+ "	 AND USUARIO_ID = " + usuario.getId()  
			+ " GROUP BY RESTAURANTEESCOLHIDO_ID" 
			+ " ORDER BY QTD_VOTOS DESC ");

		List<Object[]> resultado = query.getResultList();
		List<RankTO> rankTOByUser = new ArrayList<RankTO>(); 
		
		for (Object[] obj : resultado) {
			Restaurante restaurante = restauranteDAO.getById(Long.valueOf(String.valueOf(obj[1])));
			RankTO rankTO = new RankTO(Long.valueOf(String.valueOf(obj[0])), restaurante);
			rankTOByUser.add(rankTO);
		}
		
		return new RankUserTO(usuario, rankTOByUser);
	}
}
