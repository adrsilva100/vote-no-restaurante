package br.com.voterestaurante.dao.imp;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.voterestaurante.dao.VotacaoDAO;
import br.com.voterestaurante.entity.Votacao;

@Repository
@Transactional
public class VotacaoDAOImp extends DAOGenericaImp<Long, Votacao> implements VotacaoDAO{

	public VotacaoDAOImp(){}
	
	public VotacaoDAOImp(EntityManager entityManager) {
		super(entityManager);
	}

}
