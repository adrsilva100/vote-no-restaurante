package br.com.voterestaurante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.voterestaurante.dao.RestauranteDAO;
import br.com.voterestaurante.entity.Restaurante;

@Service
public class RestauranteService {
	
	@Autowired
	private RestauranteDAO restauranteDAO;
	
	public Restaurante get(Long id) {
		return restauranteDAO.getById(id);
	}
	
	public void salvar(Restaurante restaurante){
		restauranteDAO.salvar(restaurante);
	}
	
	public List<Restaurante> listAll(){
		return restauranteDAO.findAll();
	}
}