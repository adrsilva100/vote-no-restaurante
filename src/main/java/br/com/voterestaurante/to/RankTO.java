package br.com.voterestaurante.to;

import br.com.voterestaurante.entity.Restaurante;

public class RankTO {
	private Restaurante restaurante;
	private Long quantidadeVotos;
	
	public RankTO() {}
	
	public RankTO(Long quantidadeVotos, Restaurante restaurante) {
		super();
		this.quantidadeVotos = quantidadeVotos;
		this.restaurante = restaurante;
	}
	public Restaurante getRestaurante() {
		return restaurante;
	}
	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}
	public Long getQuantidadeVotos() {
		return quantidadeVotos;
	}
	public void setQuantidadeVotos(Long quantidadeVotos) {
		this.quantidadeVotos = quantidadeVotos;
	}
}
