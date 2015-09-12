package br.com.pat.mvc.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "mercado")
public class Mercado implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idMercado;
	private String nomeMercado;
	private Compra compra;

	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@Column(name = "id_mercado", nullable = false)
	@GeneratedValue(generator = "generator")
	public int getIdMercado() {
		return idMercado;
	}

	public void setIdMercado(int idMercado) {
		this.idMercado = idMercado;
	}

	@Column(name = "nome_mercado")
	public String getNomeMercado() {
		return nomeMercado;
	}

	public void setNomeMercado(String nomeMercado) {
		this.nomeMercado = nomeMercado;
	}

	@OneToOne(cascade = CascadeType.ALL)
	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idMercado;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mercado other = (Mercado) obj;
		if (idMercado != other.idMercado)
			return false;
		return true;
	}

}
