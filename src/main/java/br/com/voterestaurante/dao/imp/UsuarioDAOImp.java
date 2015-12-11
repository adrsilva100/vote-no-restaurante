package br.com.voterestaurante.dao.imp;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.voterestaurante.dao.UsuarioDAO;
import br.com.voterestaurante.entity.Usuario;

@Repository
@Transactional
public class UsuarioDAOImp extends DAOGenericaImp<Long, Usuario> implements UsuarioDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	public UsuarioDAOImp(){}

	public UsuarioDAOImp(EntityManager entityManager) {
		super(entityManager);
	}

	public Usuario findByNomeAndEmail(String nome, String email) {
		try {	
			Usuario resultado = entityManager.createQuery(" "
					+ " FROM Usuario u "
					+ " WHERE u.nome = '" + nome + "' "
					+ "   AND u.email = '" + email + "' ", Usuario.class).getSingleResult();
			return resultado;

		} catch(NoResultException e) {
			return null;
		}
	}
}
