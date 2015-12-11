package br.com.voterestaurante.dao.imp;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.voterestaurante.dao.DAOGenerica;

@Repository
@Transactional
public class DAOGenericaImp<PK, T> implements DAOGenerica<PK, T>{

	@PersistenceContext
	private EntityManager entityManager;

	public DAOGenericaImp(){}
	
	public DAOGenericaImp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	public T getById(PK pk) {
		return (T) entityManager.find(getTypeClass(), pk);
	}

	public void salvar(T entity) {
		entityManager.persist(entity);
	}

	public void atualizar(T entity) {
		entityManager.merge(entity);
	}

	public void deletar(T entity) {
		entityManager.remove(entity);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return entityManager.createQuery(("FROM " + getTypeClass().getName()))
				.getResultList();
	}

	private Class<?> getTypeClass() {
		Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[1];
		return clazz;
	}
}