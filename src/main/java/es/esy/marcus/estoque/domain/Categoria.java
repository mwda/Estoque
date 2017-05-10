package es.esy.marcus.estoque.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Categoria extends GenericDomain {

	@Column(length = 5, nullable = false)
	private String categoria;
	@Column(length = 300, nullable = false)
	private String descricao;
	
	

	public Categoria() {
		super();
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
