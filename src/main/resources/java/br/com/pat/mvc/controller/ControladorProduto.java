package br.com.pat.mvc.controller;

import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.pat.mvc.model.Compra;
import br.com.pat.mvc.model.ConsumoProduto;
import br.com.pat.mvc.model.Mercado;
import br.com.pat.mvc.model.Produto;
import br.com.pat.mvc.service.ProdutoService;
import br.com.pat.mvc.util.UtilMensagens;

@Controller
@Scope("session")
public class ControladorProduto {

	private Produto produto;
	private Compra compra;
	private Mercado mercado;
	private ConsumoProduto consumo;

	@Autowired
	public ProdutoService produtoService;

	public ControladorProduto() {
		compra = new Compra();
		compra.setProduto(new Produto());
		compra.setMercado(new Mercado());
	}

	public void salvar() {
		if (produtoService.salva(compra)) {
			UtilMensagens.setMsgInfo("Produto Salvo com Sucesso!");
		} else {
			UtilMensagens.setMsgInfo("Falha ao cadastrar produto!");
		}
	}

	public void novoProduto(ActionEvent actionEvent) {
		compra = new Compra();
		compra.setProduto(new Produto());
		compra.setMercado(new Mercado());
	}

	public void exportXml() {
		// TODO exportar xml
	}

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

	public Mercado getMercado() {
		return mercado;
	}

	// public List<Produto> getProdutos() {
	// compra = compraService.getDataCompra(compra);

	// return produtoService.getProdutos(produto);

	// }

	public Compra getDataCompra() {
		return compra;

	}
}
