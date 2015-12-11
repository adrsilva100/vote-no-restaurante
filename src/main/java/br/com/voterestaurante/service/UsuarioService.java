package br.com.voterestaurante.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.voterestaurante.dao.UsuarioDAO;
import br.com.voterestaurante.entity.Usuario;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioDAO usuarioDAO;
	
	public void salvar(Usuario usuario){
		usuarioDAO.salvar(usuario);
	}
	
	public Usuario findByNomeAndEmail(String nome, String email) {
		return usuarioDAO.findByNomeAndEmail(nome, email);
	}
	
	public Usuario findById(Long id){
		return usuarioDAO.getById(id);
	}
}
