package br.com.voterestaurante.to;

import java.util.List;

import br.com.voterestaurante.entity.Usuario;

public class RankUserTO {
	private Usuario usuario;
	private List<RankTO> listaRank;

	public RankUserTO() {}

	public RankUserTO(Usuario usuario, List<RankTO> listaRank) {
		this.usuario = usuario;
		this.listaRank = listaRank;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<RankTO> getListaRank() {
		return listaRank;
	}

	public void setListaRank(List<RankTO> listaRank) {
		this.listaRank = listaRank;
	}
}