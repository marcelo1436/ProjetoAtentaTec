package br.com.pat.mvc.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "produtos")
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idProduto;
	private String nomeProduto;
	private String tipoProduto;
	private String marcaProduto;
	private Integer valorProduto;
	private Date dataValidadeProduto;
	private Integer quantidadeProduto;
	private Compra compra;
	private List<ConsumoProduto> consumo;

	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@Column(name = "id_produto", nullable = false)
	@GeneratedValue(generator = "generator")
	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	@Column(name = "nome_produto")
	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	@Column(name = "tipo_produto")
	public String getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	@Column(name = "marca_produto")
	public String getMarcaProduto() {
		return marcaProduto;
	}

	public void setMarcaProduto(String marcaProduto) {
		this.marcaProduto = marcaProduto;
	}

	@NotNull
	@Column(name = "valor_produto")
	public Integer getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(Integer valorProduto) {
		this.valorProduto = valorProduto;
	}

	@Temporal(value = TemporalType.DATE)
	@Column(name = "dataValidade_produto")
	public Date getDataValidadeProduto() {
		return dataValidadeProduto;
	}

	public void setDataValidadeProduto(Date dataValidadeProduto) {
		this.dataValidadeProduto = dataValidadeProduto;
	}

	@Column(name = "quantidade_produto")
	public Integer getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(Integer quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	@OneToOne(cascade = CascadeType.ALL)
	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
	public List<ConsumoProduto> getConsumo() {
		return consumo;
	}

	public void setConsumo(List<ConsumoProduto> consumo) {
		this.consumo = consumo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idProduto;
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
		Produto other = (Produto) obj;
		if (idProduto != other.idProduto)
			return false;
		return true;
	}

}
