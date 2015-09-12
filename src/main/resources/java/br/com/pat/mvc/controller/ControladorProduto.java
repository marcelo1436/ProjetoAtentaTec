package br.com.pat.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.pat.mvc.model.Compra;
import br.com.pat.mvc.model.ConsumoProduto;
import br.com.pat.mvc.model.Produto;

@Controller
@Scope("view")
public class ControladorProduto {

	@Autowired
	private Produto produto;

	@Autowired
	private Compra compra;

	@Autowired
	private ConsumoProduto consumo;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public ConsumoProduto getConsumo() {
		return consumo;
	}

	public void setConsumo(ConsumoProduto consumo) {
		this.consumo = consumo;
	}

}
