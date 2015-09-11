package br.com.pat.mvc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "consumoproduto")
public class ConsumoProduto implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idConsumo;
	private Integer quantidadeProduto;
	private Produto produto;
	private Date dataConsumo;

	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@Column(name = "id_consumo", nullable = false)
	@GeneratedValue(generator = "generator")
	public int getIdConsumo() {
		return idConsumo;
	}

	public void setIdConsumo(int idConsumo) {
		this.idConsumo = idConsumo;
	}

	public Integer getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(Integer quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Column(name = "dataConsumo")
	public Date getDataConsumo() {
		return dataConsumo;
	}

	public void setDataConsumo(Date dataConsumo) {
		this.dataConsumo = dataConsumo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idConsumo;
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
		ConsumoProduto other = (ConsumoProduto) obj;
		if (idConsumo != other.idConsumo)
			return false;
		return true;
	}

}
