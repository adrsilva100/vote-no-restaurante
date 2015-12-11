package br.com.voterestaurante.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_RESTAURANTE")
public class Restaurante {
	
	@GeneratedValue
	@Id 
	private Long id;
	
	@Column(name="NOME", nullable=false)
	private String nome;
	
	@Column(name="IMAGEM", nullable=false)
	private String imagem;
	
	public Restaurante() {}
	
	public Restaurante(Long id, String nome, String imagem) {
		super();
		this.id = id;
		this.nome = nome;
		this.imagem = imagem;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
}
