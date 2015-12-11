package br.com.voterestaurante.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_VOTACAO")
public class Votacao {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne
	private Restaurante restaurante1;

	@OneToOne
	private Restaurante restaurante2;
	
	@OneToOne
	private Restaurante restauranteEscolhido;
	
	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(name="DATA_HORA_VOTO")
	private Date dateHourVote;
	
	@ManyToOne
	private Usuario usuario;
	
	public Votacao(){}

	public Votacao(Long id, Restaurante restaurante1, Restaurante restaurante2, Restaurante restauranteEscolhido,
			Date dateHourVote, Usuario usuario) {
		super();
		this.id = id;
		this.restaurante1 = restaurante1;
		this.restaurante2 = restaurante2;
		this.restauranteEscolhido = restauranteEscolhido;
		this.dateHourVote = dateHourVote;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Restaurante getRestaurante1() {
		return restaurante1;
	}

	public void setRestaurante1(Restaurante restaurante1) {
		this.restaurante1 = restaurante1;
	}

	public Restaurante getRestaurante2() {
		return restaurante2;
	}

	public void setRestaurante2(Restaurante restaurante2) {
		this.restaurante2 = restaurante2;
	}

	public Restaurante getRestauranteEscolhido() {
		return restauranteEscolhido;
	}

	public void setRestauranteEscolhido(Restaurante restauranteEscolhido) {
		this.restauranteEscolhido = restauranteEscolhido;
	}

	public Date getDateHourVote() {
		return dateHourVote;
	}

	public void setDateHourVote(Date dateHourVote) {
		this.dateHourVote = dateHourVote;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
