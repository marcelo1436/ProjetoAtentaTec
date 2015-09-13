package br.com.pat.mvc.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import br.com.pat.mvc.model.Produto;
import br.com.pat.mvc.repositories.ProdutoRepository;
import br.com.pat.mvc.util.UtilMensagens;

@Service
public class ProdutoService {

	@Resource(name = "produtoRepository")
	public ProdutoRepository produtoRepository;

	public Produto salva(Produto produto) {
		validaProduto(produto);
		return produtoRepository.salva(produto);
	}

	public Produto getProduto() {
		return produtoRepository.getProduto();
	}

	private void validaProduto(Produto produto) {
		if (produto.getNomeProduto() == "") {
			UtilMensagens.setMsgError("Nome do produto é Obrigatorio");
		}
		if (produto.getMarcaProduto() == "") {
			UtilMensagens.setMsgError("Marca do produto é Obrigatorio");
		}
		if (produto.getTipoProduto() == "") {
			UtilMensagens.setMsgError("Tipo do produto é Obrigatorio");
		}
		if (produto.getValorProduto() == null) {
			UtilMensagens.setMsgError("Valor do produto é Obrigatorio");
		}
		if (produto.getQuantidadeProduto() == null) {
			UtilMensagens.setMsgError("Quantidade do produto é Obrigatorio");
		}

	}
}
