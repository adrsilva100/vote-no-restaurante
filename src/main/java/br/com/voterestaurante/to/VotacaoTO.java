package br.com.voterestaurante.to;

import br.com.voterestaurante.entity.Restaurante;

public class VotacaoTO {
	private Restaurante opcao1;
	private Restaurante opcao2;
	
	public VotacaoTO() {}
	
	public VotacaoTO(Restaurante opcao1, Restaurante opcao2) {
		super();
		this.opcao1 = opcao1;
		this.opcao2 = opcao2;
	}
	public Restaurante getOpcao1() {
		return opcao1;
	}
	public void setOpcao1(Restaurante opcao1) {
		this.opcao1 = opcao1;
	}
	public Restaurante getOpcao2() {
		return opcao2;
	}
	public void setOpcao2(Restaurante opcao2) {
		this.opcao2 = opcao2;
	}
}
