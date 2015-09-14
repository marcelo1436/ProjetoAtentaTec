package br.com.pat.mvc.controller;

import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.pat.mvc.model.Compra;
import br.com.pat.mvc.model.ConsumoProduto;
import br.com.pat.mvc.model.Mercado;
import br.com.pat.mvc.model.Produto;
import br.com.pat.mvc.service.CompraService;
import br.com.pat.mvc.service.MercadoService;
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

	@Autowired
	public CompraService compraService;

	@Autowired
	public MercadoService mercadoService;

	public ControladorProduto() {
		produto = new Produto();
		compra = new Compra();
		consumo = new ConsumoProduto();
		mercado = new Mercado();
	}

	public void salvar() {
		produtoService.salva(produto);
		compraService.salva(compra);
		mercadoService.salva(mercado);
		UtilMensagens.setMsgInfo("Produto Salvo com Sucesso!");
	}

	public void novoProduto(ActionEvent actionEvent) {
		produto = new Produto();
		compra = new Compra();
		mercado = new Mercado();
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
