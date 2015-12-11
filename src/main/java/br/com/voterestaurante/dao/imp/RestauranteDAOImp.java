package br.com.voterestaurante.dao.imp;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.voterestaurante.dao.RestauranteDAO;
import br.com.voterestaurante.entity.Restaurante;

@Repository
@Transactional
public class RestauranteDAOImp extends DAOGenericaImp<Long, Restaurante> implements RestauranteDAO{

	public RestauranteDAOImp(){}
	
	public RestauranteDAOImp(EntityManager entityManager) {
		super(entityManager);
	}

}
