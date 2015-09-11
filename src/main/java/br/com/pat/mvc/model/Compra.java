package br.com.pat.mvc.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

public class Compra implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idCompra;
	private Date dataCompra;
	private List<Produto> listaProduto;
	private Mercado mercado;

	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@Column(name = "id_compra", nullable = false)
	@GeneratedValue(generator = "generator")
	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	@Column(name = "")
	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	@ManyToOne
	@JoinColumn(name = "id_produto")
	public List<Produto> getListaProduto() {
		return listaProduto;
	}

	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}

	@OneToOne(cascade = CascadeType.ALL)
	public Mercado getMercado() {
		return mercado;
	}

	public void setMercado(Mercado mercado) {
		this.mercado = mercado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCompra;
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
		Compra other = (Compra) obj;
		if (idCompra != other.idCompra)
			return false;
		return true;
	}

}
