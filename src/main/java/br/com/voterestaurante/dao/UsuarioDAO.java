package br.com.voterestaurante.dao;

import br.com.voterestaurante.entity.Usuario;

public interface UsuarioDAO extends  DAOGenerica<Long, Usuario>{
	
	public Usuario findByNomeAndEmail(String nome, String email);
}
