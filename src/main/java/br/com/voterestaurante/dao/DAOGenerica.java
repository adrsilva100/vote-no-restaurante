package br.com.voterestaurante.dao;

import java.util.List;

public interface DAOGenerica<PK, T> {
	 public void salvar(T entity);
	 public void atualizar(T entity);
	 public void deletar(T entity);
	 public List<T> findAll();
	 public T getById(PK pk);
}
