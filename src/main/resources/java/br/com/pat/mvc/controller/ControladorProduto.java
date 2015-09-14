package br.com.pat.mvc.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.pat.mvc.model.Compra;
import br.com.pat.mvc.model.Mercado;
import br.com.pat.mvc.model.Produto;
import br.com.pat.mvc.service.ProdutoService;
import br.com.pat.mvc.util.UtilMensagens;

@Controller
@Scope("session")
public class ControladorProduto {

	private Compra compra;
	private Compra compraSelecionada;
	private DataModel<Compra> dataModelCompras;

	@Autowired
	public ProdutoService produtoService;

	public ControladorProduto() {
		compra = new Compra();
		compra.setProduto(new Produto());
		compra.setMercado(new Mercado());
	}

	@PostConstruct
	public void init() {
		dataModelCompras = new ListDataModel<Compra>(getCompras());
	}

	public void salvar() {
		if (produtoService.salva(compra)) {
			dataModelCompras = new ListDataModel<Compra>(getCompras());
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

	public void consumirProduto() {
		compraSelecionada = dataModelCompras.getRowData();
		produtoService.consumirProduto(compraSelecionada);
		UtilMensagens.setMsgInfo("Produto consumido!");
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Compra getCompraSelecionada() {
		return compraSelecionada;
	}

	public void setCompraSelecionada(Compra compraSelecionada) {
		this.compraSelecionada = compraSelecionada;
	}

	public DataModel<Compra> getDataModelCompras() {
		return dataModelCompras;
	}

	public void setDataModelCompras(DataModel<Compra> dataModelCompras) {
		this.dataModelCompras = dataModelCompras;
	}

	public List<Compra> getCompras() {
		return produtoService.getCompras();
	}

	public Compra getDataCompra() {
		return compra;

	}

	public void Limpar() {
		compra = new Compra();
	}
}
